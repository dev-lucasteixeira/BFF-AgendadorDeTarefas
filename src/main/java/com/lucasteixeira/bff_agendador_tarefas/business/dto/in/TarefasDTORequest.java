package com.lucasteixeira.bff_agendador_tarefas.business.dto.in;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTORequest {

    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataEvento;

}
