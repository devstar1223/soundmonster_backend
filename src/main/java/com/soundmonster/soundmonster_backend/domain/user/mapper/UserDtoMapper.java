package com.soundmonster.soundmonster_backend.domain.user.mapper;

import com.soundmonster.soundmonster_backend.domain.user.dto.controller.request.LoginRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.controller.response.LoginResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.controller.request.SignUpRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.controller.response.SignUpResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.request.ServiceLoginRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.request.ServiceSignUpRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.response.ServiceLoginResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.response.ServiceSignUpResponse;

public final class UserDtoMapper {

    private UserDtoMapper() {
    }

    public static ServiceSignUpRequest toServicePostUsersRequest(SignUpRequest request) {
        return new ServiceSignUpRequest(
                request.getUsername(),
                request.getPassword(),
                request.getEmail(),
                request.getName(),
                request.getNickname()
        );
    }

    public static SignUpResponse toPostUsersResponse(ServiceSignUpResponse response) {
        return new SignUpResponse(
                response.getNickname(),
                response.getJwt()
        );
    }
    
    public static ServiceLoginRequest toServicePostUsersLoginRequest(LoginRequest request) {
        return new ServiceLoginRequest(
                request.getUsername(),
                request.getPassword()
        );
    }
    
    public static LoginResponse toPostUsersLoginResponse(ServiceLoginResponse response){
        return new LoginResponse(response.getJwt());
    }
}
