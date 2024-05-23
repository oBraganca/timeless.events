package com.timeless.events.handler.exceptions;


import com.timeless.events.enums.InternalErrosEnum;

public class NotFoundException extends BaseException {


    public NotFoundException(){
        super(InternalErrosEnum.ERR404);
    }

    public NotFoundException(String message){
        super(InternalErrosEnum.ERR404, message);
    }
}
