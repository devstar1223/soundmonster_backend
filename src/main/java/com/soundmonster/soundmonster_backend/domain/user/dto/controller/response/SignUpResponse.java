package com.soundmonster.soundmonster_backend.domain.user.dto.controller.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class SignUpResponse {
    private final String nickname;
    private final String jwt;
}
