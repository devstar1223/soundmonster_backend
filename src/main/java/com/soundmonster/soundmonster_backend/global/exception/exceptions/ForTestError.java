package com.soundmonster.soundmonster_backend.global.exception.exceptions;

import com.soundmonster.soundmonster_backend.global.exception.model.BaseException;
import com.soundmonster.soundmonster_backend.global.exception.model.ErrorCode;
import lombok.Getter;

@Getter
public class ForTestError extends BaseException {
    public ForTestError() {
        super(ErrorCode.FOR_TEST_ERROR);
    }
}
