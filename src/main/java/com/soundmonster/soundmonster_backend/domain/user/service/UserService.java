package com.soundmonster.soundmonster_backend.domain.user.service;

import com.soundmonster.soundmonster_backend.domain.user.dto.service.request.ServiceLoginRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.request.ServiceSignUpRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.response.ServiceLoginResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.response.ServiceSignUpResponse;
import com.soundmonster.soundmonster_backend.domain.user.entity.User;
import com.soundmonster.soundmonster_backend.domain.user.entity.UserRole;
import com.soundmonster.soundmonster_backend.domain.user.repository.UserRepository;
import com.soundmonster.soundmonster_backend.global.exception.exceptions.auth.EmailAlreadyExistsException;
import com.soundmonster.soundmonster_backend.global.exception.exceptions.auth.InvalidLoginCredentialsException;
import com.soundmonster.soundmonster_backend.global.exception.exceptions.auth.NicknameAlreadyExistsException;
import com.soundmonster.soundmonster_backend.global.exception.exceptions.auth.UsernameAlreadyExistsException;
import com.soundmonster.soundmonster_backend.global.exception.exceptions.user.UserNotFoundException;
import com.soundmonster.soundmonster_backend.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public ServiceSignUpResponse signUp(ServiceSignUpRequest serviceSignUpRequest) {
        validateUniqueUserFields(serviceSignUpRequest);
        User user = createUser(serviceSignUpRequest);
        userRepository.save(user);
        String jwt = jwtProvider.createToken(user);
        return new ServiceSignUpResponse(user.getNickname(), jwt);
    }

    public ServiceLoginResponse login(ServiceLoginRequest request) {
        User user = findActiveUserByUsername(request.getUsername());
        validatePassword(user, request.getPassword());
        String jwt = jwtProvider.createToken(user);
        return new ServiceLoginResponse(jwt, user.getNickname());
    }

    private void validateUniqueUserFields(ServiceSignUpRequest request) {
        validateUniqueUsername(request.getUsername());
        validateUniqueEmail(request.getEmail());
        validateUniqueNickname(request.getNickname());
    }

    private void validateUniqueUsername(String username) {
        userRepository.findByUsernameAndIsActiveTrue(username)
                .ifPresent(user -> {
                    throw new UsernameAlreadyExistsException();
                });
    }

    private void validateUniqueEmail(String email) {
        userRepository.findByEmailAndIsActiveTrue(email)
                .ifPresent(user -> {
                    throw new EmailAlreadyExistsException();
                });
    }

    private void validateUniqueNickname(String nickname) {
        userRepository.findByNicknameAndIsActiveTrue(nickname)
                .ifPresent(user -> {
                    throw new NicknameAlreadyExistsException();
                });
    }

    private User createUser(ServiceSignUpRequest request) {
        //TODO. 비밀번호 암호화
        return User.of(
                request.getUsername(),
                request.getPassword(),
                request.getName(),
                request.getEmail(),
                request.getNickname(),
                UserRole.USER,
                true
        );
    }

    private User findActiveUserByUsername(String username) {
        return userRepository.findByUsernameAndIsActiveTrue(username)
                .orElseThrow(InvalidLoginCredentialsException::new);
    }

    private void validatePassword(User user, String password) {
        if (user.getPassword().equals(password)) {
           return;
        }
        throw new InvalidLoginCredentialsException();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
