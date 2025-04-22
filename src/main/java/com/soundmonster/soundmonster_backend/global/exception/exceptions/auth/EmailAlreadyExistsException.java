package com.soundmonster.soundmonster_backend.global.exception.exceptions.auth;

import com.soundmonster.soundmonster_backend.global.exception.model.BaseException;
import com.soundmonster.soundmonster_backend.global.exception.model.ErrorCode;

public class EmailAlreadyExistsException extends BaseException {
    public EmailAlreadyExistsException() {
        super(ErrorCode.EMAIL_ALREADY_EXISTS);
    }
}