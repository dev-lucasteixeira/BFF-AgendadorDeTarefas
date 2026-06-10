package com.lucasteixeira.bff_agendador_tarefas.infrastructure.client.config;

import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.BusinessException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.ConflictException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.ForbiddenException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.IllegalArgumentException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.exceptions.UnauhthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response){

        String mensagemErro = mensagemErro(response);

        switch (response.status()){
            case 409: return new ConflictException(mensagemErro);
            case 403: return new ForbiddenException(mensagemErro);
            case 401: return new UnauhthorizedException(mensagemErro);
            case 400: return new IllegalArgumentException(mensagemErro);
            default: return new BusinessException(mensagemErro);
        }
    }

    private String mensagemErro(Response response){
        try {
            if(Objects.isNull(response.body())){
                return "";
            }

            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
