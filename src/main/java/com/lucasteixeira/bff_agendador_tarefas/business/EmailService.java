package com.lucasteixeira.bff_agendador_tarefas.business;



import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto){
        emailClient.enviaEmail(dto);
    }

}
