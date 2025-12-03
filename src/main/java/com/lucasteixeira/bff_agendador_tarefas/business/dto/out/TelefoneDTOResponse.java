package com.lucasteixeira.bff_agendador_tarefas.business.dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTOResponse {

    private Long id;
    private String ddd;
    private String numero;
}
