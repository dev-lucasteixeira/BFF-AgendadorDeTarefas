package com.lucasteixeira.bff_agendador_tarefas.business.dto.out;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTOResponse {

    private String nome;
    private String email;
    private String senha;
    @JsonProperty("enderecos")
    @JsonAlias("endereco")
    private List<EnderecoDTOResponse> endereco;
    @JsonProperty("telefones")
    @JsonAlias("telefone")
    private List<TelefoneDTOResponse> telefone;
}
