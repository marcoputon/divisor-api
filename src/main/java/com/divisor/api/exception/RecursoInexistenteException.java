package com.divisor.api.exception;


public class RecursoInexistenteException extends RuntimeException {
    public RecursoInexistenteException(String errorMessage) {
        super(errorMessage);
    }
}