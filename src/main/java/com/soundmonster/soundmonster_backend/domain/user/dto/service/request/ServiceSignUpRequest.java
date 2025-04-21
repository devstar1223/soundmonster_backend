package com.soundmonster.soundmonster_backend.domain.user.dto.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ServiceSignUpRequest {
    private final String username;
    private final String password;
    private final String email;
    private final String name;
    private final String nickname;
}
