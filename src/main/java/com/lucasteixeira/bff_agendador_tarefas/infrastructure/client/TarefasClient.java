package com.lucasteixeira.bff_agendador_tarefas.infrastructure.client;



import com.lucasteixeira.bff_agendador_tarefas.business.dto.in.TarefasDTORequest;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.lucasteixeira.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-de-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefa(@RequestBody TarefasDTORequest tarefasDTO);


    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataFinal);

    @GetMapping
    List<TarefasDTOResponse> buscaListaDeTarefasPorEmail();

    @DeleteMapping
    void deletaTarefaPorId(@RequestParam String id);

    @PatchMapping
    TarefasDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                               @RequestParam("id") String id);

    @PutMapping
    TarefasDTOResponse UpdateTarefa(@RequestBody TarefasDTORequest dto,
                                    @RequestParam("id") String id);
}
