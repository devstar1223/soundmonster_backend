package com.soundmonster.soundmonster_backend.domain.user.service;

import com.soundmonster.soundmonster_backend.domain.user.dto.service.request.ServiceLoginRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.request.ServiceSignUpRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.response.ServiceLoginResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.response.ServiceSignUpResponse;
import com.soundmonster.soundmonster_backend.domain.user.entity.User;
import com.soundmonster.soundmonster_backend.domain.user.entity.UserRole;
import com.soundmonster.soundmonster_backend.domain.user.repository.UserRepository;
import com.soundmonster.soundmonster_backend.global.exception.exceptions.PasswordMismatch;
import com.soundmonster.soundmonster_backend.global.exception.exceptions.UserNotFoundException;
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
        //TODO. 비밀번호 암호화
        User user = User.of(
                serviceSignUpRequest.getUsername(),
                serviceSignUpRequest.getPassword(),
                serviceSignUpRequest.getName(),
                serviceSignUpRequest.getEmail(),
                serviceSignUpRequest.getNickname(),
                UserRole.USER,
                true
        );

        userRepository.save(user);

        String jwt = jwtProvider.createToken(user);

        return new ServiceSignUpResponse(user.getNickname(), jwt);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public ServiceLoginResponse login(ServiceLoginRequest request) {
        User user = userRepository.findByUsernameAndIsActiveTrue(request.getUsername())
                .orElseThrow(UserNotFoundException::new);

        if (!user.getPassword().equals(request.getPassword())) {
            throw new PasswordMismatch();
        }

        String jwt = jwtProvider.createToken(user);

        return new ServiceLoginResponse(jwt);
    }
}
