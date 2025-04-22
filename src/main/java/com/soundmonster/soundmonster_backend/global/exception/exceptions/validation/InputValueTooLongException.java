package com.soundmonster.soundmonster_backend.global.exception.exceptions.validation;

import com.soundmonster.soundmonster_backend.global.exception.model.BaseException;
import com.soundmonster.soundmonster_backend.global.exception.model.ErrorCode;

public class InputValueTooLongException extends BaseException {
    public InputValueTooLongException() {
        super(ErrorCode.INPUT_VALUE_TOO_LONG);
    }
}
