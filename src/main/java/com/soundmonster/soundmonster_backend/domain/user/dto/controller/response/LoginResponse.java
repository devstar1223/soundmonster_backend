package com.soundmonster.soundmonster_backend.domain.user.dto.controller.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginResponse {
    private final String jwt;
    private final String nickname;
}
