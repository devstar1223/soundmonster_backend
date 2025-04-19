package com.soundmonster.soundmonster_backend.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ServicePostUsersRequest {
    private final String username;
    private final String password;
    private final String email;
    private final String name;
    private final String nickname;
}
