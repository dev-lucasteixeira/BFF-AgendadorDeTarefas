package com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String mensagem){
        super(mensagem);
    }

    public ForbiddenException(String mensagem, Throwable throwable){
        super(mensagem);
    }
}
