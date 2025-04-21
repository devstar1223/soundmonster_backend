package com.soundmonster.soundmonster_backend.domain.user.service;

import com.soundmonster.soundmonster_backend.domain.user.dto.ServicePostUsersRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.ServicePostUsersResponse;
import com.soundmonster.soundmonster_backend.domain.user.entity.User;
import com.soundmonster.soundmonster_backend.domain.user.entity.UserRole;
import com.soundmonster.soundmonster_backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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

        // TODO. JWT 발급 구현
        String jwt = "asdf1234";

        return new ServicePostUsersResponse(user.getNickname(), jwt);
    }
}
