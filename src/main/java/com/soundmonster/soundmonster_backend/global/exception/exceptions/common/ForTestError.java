package com.soundmonster.soundmonster_backend.global.exception.exceptions.common;

import com.soundmonster.soundmonster_backend.global.exception.model.BaseException;
import com.soundmonster.soundmonster_backend.global.exception.model.ErrorCode;

public class ForTestError extends BaseException {
    public ForTestError() {
        super(ErrorCode.FOR_TEST_ERROR);
    }
}
