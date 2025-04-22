package com.soundmonster.soundmonster_backend.global.exception.exceptions.auth;

import com.soundmonster.soundmonster_backend.global.exception.model.BaseException;
import com.soundmonster.soundmonster_backend.global.exception.model.ErrorCode;

public class InvalidLoginCredentialsException extends BaseException {
    public InvalidLoginCredentialsException() {
        super(ErrorCode.INVALID_LOGIN_CREDENTIALS);
    }
}