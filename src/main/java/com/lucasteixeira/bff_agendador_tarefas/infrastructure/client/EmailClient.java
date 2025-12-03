package com.lucasteixeira.bff_agendador_tarefas.infrastructure.client;


import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${noificacao.url}")
public interface EmailClient {

    ResponseEntity<Void> enviarEmail(@RequestBody TarefasDTOResponse dto);
}
