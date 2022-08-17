package com.sicredi.exercicio2.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

       List<Erro> erros = generationErrors(ex.getBindingResult());

        return handleExceptionInternal(ex,erros,new HttpHeaders(),HttpStatus.BAD_REQUEST,request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private List<Erro> generationErrors(BindingResult bindingResult) {
        List<Erro> erros = new ArrayList<Erro>();

        bindingResult.getFieldErrors().forEach( fieldError -> {
            String msgUser = fieldError.getDefaultMessage();
            String msgDev = fieldError.toString();
            erros.add(new Erro(msgUser,msgDev));
        });
        return erros;
    }
}
