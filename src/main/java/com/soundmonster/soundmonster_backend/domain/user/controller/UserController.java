package com.soundmonster.soundmonster_backend.domain.user.controller;

import com.soundmonster.soundmonster_backend.domain.user.dto.controller.request.LoginRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.controller.response.LoginResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.controller.request.SignUpRequest;
import com.soundmonster.soundmonster_backend.domain.user.dto.controller.response.SignUpResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.response.ServiceLoginResponse;
import com.soundmonster.soundmonster_backend.domain.user.dto.service.response.ServiceSignUpResponse;
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
    public ResponseEntity<ApiResponse<SignUpResponse>> signUp(@RequestBody SignUpRequest request) {
        ServiceSignUpResponse serviceResponse = userService.signUp(toServicePostUsersRequest(request));

        return ResponseEntity.ok(ApiResponse.ok(toPostUsersResponse(serviceResponse), "회원가입 완료"));
    }

    @PostMapping("/login")
    @Operation(
            summary = "이용자 로그인",
            description = """    
                    로그인 API (추후 설명 추가)
                    """
    )
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        ServiceLoginResponse serviceResponse = userService.login(toServicePostUsersLoginRequest(request));

        return ResponseEntity.ok(ApiResponse.ok(toPostUsersLoginResponse(serviceResponse),"로그인 완료"));
    }
}
