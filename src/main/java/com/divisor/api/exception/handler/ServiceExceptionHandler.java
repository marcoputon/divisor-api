package com.divisor.api.exception.handler;

import com.divisor.api.exception.RecursoInexistenteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {

    private static final String mensagem = "(exceção): (mensagem).";


    private String formatarMensagem(Exception e) {
        return mensagem
                .replace("(mensagem)", e.getMessage())
                .replace("(exceção)", e.getClass().getSimpleName());
    }


    @ExceptionHandler(RecursoInexistenteException.class)
    public ResponseEntity<Object> handleRecursoInexistenteException(RecursoInexistenteException rie) {
        return ResponseEntity.badRequest().body(formatarMensagem(rie));
    }
}
