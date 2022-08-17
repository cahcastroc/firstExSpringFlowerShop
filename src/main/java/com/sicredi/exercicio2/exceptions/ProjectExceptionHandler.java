package com.sicredi.exercicio2.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ProjectExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

       List<Erro> erros = generationErrors(ex.getBindingResult());

        return handleExceptionInternal(ex,erros,new HttpHeaders(),HttpStatus.BAD_REQUEST,request);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException (EmptyResultDataAccessException ex, WebRequest request){
        String msgUser = "O recurso solicitado não existe";
        String msgDev = ex.toString();

        List<Erro> erros = Arrays.asList(new Erro(msgUser,msgDev));

        return handleExceptionInternal(ex,erros,new HttpHeaders(),HttpStatus.NOT_FOUND,request);

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
