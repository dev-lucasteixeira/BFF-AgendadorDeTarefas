package com.lucasteixeira.bff_agendador_tarefas.business.services;



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
public class TarefaService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefa(TarefasDTORequest tarefasDTO){
        return tarefasClient.gravarTarefa(tarefasDTO);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dataFinal){
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(){
        return tarefasClient.buscaListaDeTarefasPorEmail();
    }

    public void deletaTarefaPorId(String id){
        tarefasClient.deletaTarefaPorId(id);

    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id){
        return tarefasClient.alteraStatusNotificacao(status, id);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id){
        return tarefasClient.UpdateTarefa(dto, id);
    }


}
