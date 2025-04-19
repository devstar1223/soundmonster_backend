package com.soundmonster.soundmonster_backend.domain.user.controller;

import com.soundmonster.soundmonster_backend.domain.user.dto.PostUsersRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.PostUsersResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.ServicePostUsersResponse;
import com.soundmonster.soundmonster_backend.domain.user.service.UserService;
import com.soundmonster.soundmonster_backend.global.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.soundmonster.soundmonster_backend.domain.user.mapper.UserDtoMapper.toPostUsersResponse;
import static com.soundmonster.soundmonster_backend.domain.user.mapper.UserDtoMapper.toServicePostUsersRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    @Operation(
            summary = "이용자 회원가입",
            description = """    
                    회원가입 API (추후 설명 추가)
                    """
//            security = @SecurityRequirement(name = "JWT")
    )
    public ResponseEntity<ApiResponse<PostUsersResponse>> postUsers(@RequestBody PostUsersRequest request) {
        ServicePostUsersResponse serviceResponse = userService.postUsers(toServicePostUsersRequest(request));

        return ResponseEntity.ok(ApiResponse.ok(toPostUsersResponse(serviceResponse), "회원가입 완료"));
    }
}
