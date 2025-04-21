package com.soundmonster.soundmonster_backend.global.exception.exceptions;

import com.soundmonster.soundmonster_backend.global.exception.model.BaseException;
import com.soundmonster.soundmonster_backend.global.exception.model.ErrorCode;

public class InvalidSortParameterException extends BaseException {
    public InvalidSortParameterException() {
        super(ErrorCode.INVALID_SORT_PARAMETER);
    }
}
