package com.soundmonster.soundmonster_backend.global.exception.exceptions.user;

import com.soundmonster.soundmonster_backend.global.exception.model.BaseException;
import com.soundmonster.soundmonster_backend.global.exception.model.ErrorCode;

public class UserMismatchException extends BaseException {
    public UserMismatchException() {
        super(ErrorCode.USER_MISMATCH);
    }
}
