package com.backend_bico.bico.exceptionHandler;

public class InvalidPasswordException extends UnprocessableEntityException {

    public InvalidPasswordException(String s) {
        super(s);
    }

}
