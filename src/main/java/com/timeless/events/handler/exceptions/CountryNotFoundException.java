package com.timeless.events.handler.exceptions;


import com.timeless.events.enums.InternalErrosEnum;

public class CountryNotFoundException extends BaseException {


    public CountryNotFoundException(){
        super(InternalErrosEnum.ERR404);
    }

    public CountryNotFoundException(String message){
        super(InternalErrosEnum.ERR404, message);
    }
}
