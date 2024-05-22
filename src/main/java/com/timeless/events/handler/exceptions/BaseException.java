package com.timeless.events.handler.exceptions;

import com.timeless.events.enums.InternalErrosEnum;

public class BaseException extends Exception {
    private final InternalErrosEnum error;

    protected BaseException(InternalErrosEnum error) {
        super(error.getMessage());
        this.error = error;
    }

    protected BaseException(InternalErrosEnum errorcode, Object... args) {
        super(String.format(errorcode.getMessage(), args));
        this.error = errorcode;
    }

    public InternalErrosEnum getErrorCode() {
        return error;
    }
}