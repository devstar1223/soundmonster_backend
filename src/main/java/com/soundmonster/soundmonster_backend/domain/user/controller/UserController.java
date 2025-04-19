package com.soundmonster.soundmonster_backend.domain.user.controller;

import com.soundmonster.soundmonster_backend.domain.user.dto.PostUsersRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.PostUsersResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.ServicePostUsersResponse;
import com.soundmonster.soundmonster_backend.domain.user.service.UserService;
import com.soundmonster.soundmonster_backend.global.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.soundmonster.soundmonster_backend.domain.user.mapper.UserDtoMapper.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse<PostUsersResponse>> postUsers(@RequestBody PostUsersRequest request) {
        ServicePostUsersResponse serviceResponse = userService.postUsers(toServicePostUsersRequest(request));

        return ResponseEntity.ok(ApiResponse.ok(toPostUsersResponse(serviceResponse),"회원가입 완료"));
    }
}
