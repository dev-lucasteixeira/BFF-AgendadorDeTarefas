package com.lucasteixeira.bff_agendador_tarefas.controller;

import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.ConflictException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.UnauhthorizedException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.IllegalArgumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handlerConflictException(ConflictException conflictException){
        return new ResponseEntity<>(conflictException.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauhthorizedException.class)
    public ResponseEntity<String> handlerUnauhthorizedException(UnauhthorizedException unauhthorizedException){
        return new ResponseEntity<>(unauhthorizedException.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerIllegalArgumentException(IllegalArgumentException illegalArgumentException){
        return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
