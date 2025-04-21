package com.soundmonster.soundmonster_backend.domain.user.mapper;

import com.soundmonster.soundmonster_backend.domain.user.dto.*;

public final class UserDtoMapper {

    private UserDtoMapper() {
    }

    public static ServicePostUsersRequest toServicePostUsersRequest(PostUsersRequest request) {
        return new ServicePostUsersRequest(
                request.getUsername(),
                request.getPassword(),
                request.getEmail(),
                request.getName(),
                request.getNickname()
        );
    }

    public static PostUsersResponse toPostUsersResponse(ServicePostUsersResponse response) {
        return new PostUsersResponse(
                response.getNickname(),
                response.getJwt()
        );
    }
    
    public static ServicePostUsersLoginRequest toServicePostUsersLoginRequest(PostUsersLoginRequest request) {
        return new ServicePostUsersLoginRequest(
                request.getUsername(),
                request.getPassword()
        );
    }
    
    public static PostUsersLoginResponse toPostUsersLoginResponse(ServicePostUsersLoginResponse response){
        return new PostUsersLoginResponse(response.getJwt());
    }
}
