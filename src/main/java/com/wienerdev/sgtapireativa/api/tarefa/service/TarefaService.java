package com.wienerdev.sgtapireativa.api.tarefa.service;

import com.wienerdev.sgtapireativa.api.tarefa.document.TarefaDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service da tarefa para acesso aos métodos da API de tarefas.
 * 
 * @author Matheus Nicolay Ulharuso Wiener
 * @version 1.0
 * @since 1.0
 */
public interface TarefaService {
    
    Flux<TarefaDTO> findAll();
    Mono<TarefaDTO> getById(String id);
    Mono<TarefaDTO> saveTarefa(TarefaDTO tarefa);
    void deleteTarefaById(String id);
    Mono<TarefaDTO> updateTarefaById(String id, TarefaDTO tarefa);
    
}
