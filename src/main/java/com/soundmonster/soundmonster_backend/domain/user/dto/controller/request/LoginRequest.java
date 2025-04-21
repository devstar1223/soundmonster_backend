package com.soundmonster.soundmonster_backend.domain.user.dto.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginRequest {
    private final String username;
    private final String password;
}
