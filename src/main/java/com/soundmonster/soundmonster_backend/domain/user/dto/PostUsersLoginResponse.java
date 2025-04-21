package com.soundmonster.soundmonster_backend.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class PostUsersLoginResponse {
    private final String jwt;
}
