package com.timeless.events.handler.exceptions;


import com.timeless.events.enums.InternalErrosEnum;

public class AlreadyExistsException extends BaseException {


    public AlreadyExistsException(){
        super(InternalErrosEnum.ERR409);
    }

    public AlreadyExistsException(String message){
        super(InternalErrosEnum.ERR409, message);
    }
}
