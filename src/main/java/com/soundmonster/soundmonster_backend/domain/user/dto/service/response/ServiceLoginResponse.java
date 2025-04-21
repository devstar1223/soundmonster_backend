package com.soundmonster.soundmonster_backend.domain.user.dto.service.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ServiceLoginResponse {
    private final String jwt;
}
