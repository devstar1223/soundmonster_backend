package com.soundmonster.soundmonster_backend.domain.user.mapper;

import com.soundmonster.soundmonster_backend.domain.user.dto.PostUsersRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.PostUsersResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.ServicePostUsersRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.ServicePostUsersResponse;

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
}
