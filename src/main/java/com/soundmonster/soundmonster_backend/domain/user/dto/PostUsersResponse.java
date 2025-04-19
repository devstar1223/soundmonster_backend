package com.soundmonster.soundmonster_backend.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class PostUsersResponse {
    private final String nickname;
    private final String jwt;
}
