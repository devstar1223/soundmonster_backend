package com.soundmonster.soundmonster_backend.domain.user.service;

import com.soundmonster.soundmonster_backend.domain.user.dto.ServicePostUsersRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.ServicePostUsersResponse;
import com.soundmonster.soundmonster_backend.domain.user.entity.User;
import com.soundmonster.soundmonster_backend.domain.user.entity.UserRole;
import com.soundmonster.soundmonster_backend.domain.user.repository.UserRepository;
import com.soundmonster.soundmonster_backend.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public ServicePostUsersResponse postUsers(ServicePostUsersRequest servicePostUsersRequest) {
        //TODO. 비밀번호 암호화
        User user = User.of(
                servicePostUsersRequest.getUsername(),
                servicePostUsersRequest.getPassword(),
                servicePostUsersRequest.getName(),
                servicePostUsersRequest.getEmail(),
                servicePostUsersRequest.getNickname(),
                UserRole.USER,
                true
        );

        userRepository.save(user);

        String jwt = jwtProvider.createToken(user);

        return new ServicePostUsersResponse(user.getNickname(), jwt);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
