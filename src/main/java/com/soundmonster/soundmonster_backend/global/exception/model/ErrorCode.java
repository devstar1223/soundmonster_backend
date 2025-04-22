package com.soundmonster.soundmonster_backend.global.exception.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // auth (E1xx)
    USERNAME_ALREADY_EXISTS(HttpStatus.CONFLICT, "E100", "이미 사용 중인 ID입니다."),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "E101", "이미 등록된 이메일입니다."),
    NICKNAME_ALREADY_EXISTS(HttpStatus.CONFLICT, "E102", "이미 사용 중인 닉네임입니다."),
    PASSWORD_CONFIRM_MISMATCH(HttpStatus.BAD_REQUEST, "E103", "비밀번호와 비밀번호 확인이 일치하지 않습니다."),
    INVALID_LOGIN_CREDENTIALS(HttpStatus.UNAUTHORIZED, "E110", "아이디 또는 비밀번호가 일치하지 않습니다."),

    // user (E2xx)
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "E200", "해당 유저를 찾을 수 없습니다."),
    USER_MISMATCH(HttpStatus.FORBIDDEN, "E201", "인증된 사용자 정보와 요청한 사용자 정보가 일치하지 않습니다."),

    // validation (E3xx)
    INVALID_SORT_PARAMETER(HttpStatus.BAD_REQUEST, "E300", "해당 정렬 타입이 존재하지 않습니다."),
    INPUT_VALUE_TOO_LONG(HttpStatus.BAD_REQUEST, "E301", "입력한 값이 글자 제한을 초과했습니다."),

    // common (E9xx)
    FOR_TEST_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E900", "테스트용 에러 코드");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}