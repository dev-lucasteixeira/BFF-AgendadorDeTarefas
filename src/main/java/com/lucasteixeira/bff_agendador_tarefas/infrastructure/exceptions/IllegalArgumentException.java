package com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions;

public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(String message) {
        super(message);
    }
}
