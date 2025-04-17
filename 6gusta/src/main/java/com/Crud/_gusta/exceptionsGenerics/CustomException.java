package com.Crud._gusta.exceptionsGenerics;

public class CustomException extends RuntimeException {

    private final String errorCode;


    public CustomException(String message) {
        super(message);
        this.errorCode = "GENERIC_ERROR";
    }


    public CustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }


    public CustomException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
