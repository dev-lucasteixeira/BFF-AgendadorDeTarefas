package com.lucasteixeira.bff_agendador_tarefas.business;



import com.lucasteixeira.bff_agendador_tarefas.business.dto.in.TarefasDTORequest;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.lucasteixeira.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailService tarefasClient;

    public TarefasDTOResponse enviaEmail(TarefasDTOResponse dto){
        return tarefasClient.enviaEmail(dto);
    }

}
