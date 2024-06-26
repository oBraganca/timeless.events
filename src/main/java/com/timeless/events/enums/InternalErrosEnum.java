package com.timeless.events.enums;

public enum InternalErrosEnum {


    ERR500("500", "Internal error."),
    ERR402("402", "Invalid Request"),
    ERR404("404", "%s not found."),
    ERR409("409", "%s Already Exists") ;

    private final String code;
    private final String message;

    InternalErrosEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("Error code: %s = %s.", getCode(), getMessage());
    }
}
