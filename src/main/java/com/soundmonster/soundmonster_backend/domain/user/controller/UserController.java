package com.soundmonster.soundmonster_backend.domain.user.controller;

import com.soundmonster.soundmonster_backend.domain.user.dto.*;
import com.soundmonster.soundmonster_backend.domain.user.service.UserService;
import com.soundmonster.soundmonster_backend.global.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.soundmonster.soundmonster_backend.domain.user.mapper.UserDtoMapper.*;

@CrossOrigin(origins = {
        "http://127.0.0.1:3000",
        "http://localhost:3000"
})
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

    @PostMapping("/login")
    @Operation(
            summary = "이용자 로그인",
            description = """    
                    로그인 API (추후 설명 추가)
                    """
    )
    public ResponseEntity<ApiResponse<PostUsersLoginResponse>> login(@RequestBody PostUsersLoginRequest request) {
        ServicePostUsersLoginResponse serviceResponse = userService.postUsersLogin(toServicePostUsersLoginRequest(request));

        return ResponseEntity.ok(ApiResponse.ok(toPostUsersLoginResponse(serviceResponse),"로그인 완료"));
    }
}
