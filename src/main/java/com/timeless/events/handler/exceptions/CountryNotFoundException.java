package com.timeless.events.handler.exceptions;


import com.timeless.events.enums.InternalTypeErrorCodesEnum;

public class CountryNotFoundException extends ErrorCodeException{


    public CountryNotFoundException(){
        super(InternalTypeErrorCodesEnum.E404000);
    }

    public CountryNotFoundException(String message){
        super(InternalTypeErrorCodesEnum.E404000, message);
    }
}