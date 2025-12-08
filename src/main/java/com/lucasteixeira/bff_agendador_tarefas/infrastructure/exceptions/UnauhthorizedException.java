package com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions;


public class UnauhthorizedException extends RuntimeException {
    public UnauhthorizedException(String message) {
        super(message);
    }
}
