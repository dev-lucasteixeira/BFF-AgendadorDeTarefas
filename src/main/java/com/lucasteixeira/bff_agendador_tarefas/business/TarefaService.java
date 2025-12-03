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
public class TarefaService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefa(TarefasDTORequest tarefasDTO, String token){
        return tarefasClient.gravarTarefa(tarefasDTO, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dataFinal,
                                                                    String token){
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token){
        return tarefasClient.buscaListaDeTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token){
        tarefasClient.deletaTarefaPorId(id, token);

    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token){
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token){
        return tarefasClient.UpdateTarefa(dto, id, token);
    }


}
