package com.lucasteixeira.bff_agendador_tarefas.business.dto.in;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;
    @JsonAlias("enderecos")
    private List<EnderecoDTORequest> endereco;
    @JsonAlias("telefones")
    private List<TelefoneDTORequest> telefone;
}
