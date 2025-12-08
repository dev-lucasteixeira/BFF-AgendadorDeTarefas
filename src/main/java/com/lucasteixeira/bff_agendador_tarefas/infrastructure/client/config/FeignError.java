package com.lucasteixeira.bff_agendador_tarefas.infrastructure.client.config;

import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.BusinessException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.ConflictException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.UnauhthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response){
        switch (response.status()){
            case 409: return new ConflictException("Erro atributo já existente");
            case 403: return new ResourceNotFoundException("Erro atributo não encontrado");
            case 401: return new UnauhthorizedException("Erro usuário não autorizado");
            default: return new BusinessException("Erro inesperado");
        }
    }
}
