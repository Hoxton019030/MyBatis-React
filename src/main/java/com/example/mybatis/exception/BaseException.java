package com.example.mybatis.exception;

public class BaseException extends RuntimeException{
    private final String errorMsg;


    protected BaseException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }
}
