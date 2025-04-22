package com.soundmonster.soundmonster_backend.global.exception.exceptions.auth; // 패키지 경로 변경 권장

import com.soundmonster.soundmonster_backend.global.exception.model.BaseException;
import com.soundmonster.soundmonster_backend.global.exception.model.ErrorCode;


public class PasswordConfirmMismatch extends BaseException {
    public PasswordConfirmMismatch() {
        super(ErrorCode.PASSWORD_CONFIRM_MISMATCH);
    }
}