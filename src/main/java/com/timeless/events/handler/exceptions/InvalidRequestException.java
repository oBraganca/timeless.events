package com.timeless.events.handler.exceptions;

import com.timeless.events.enums.InternalErrosEnum;

public class InvalidRequestException extends BaseException{

    protected InvalidRequestException() {
        super(InternalErrosEnum.ERR402);
    }
}
