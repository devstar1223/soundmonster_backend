package com.soundmonster.soundmonster_backend.global.exception.exceptions;

import com.soundmonster.soundmonster_backend.global.exception.model.BaseException;
import com.soundmonster.soundmonster_backend.global.exception.model.ErrorCode;
import lombok.Getter;

@Getter
public class PasswordMismatch extends BaseException {
    public PasswordMismatch() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
