package com.wienerdev.sgtapireativa.api.tarefa.service;

import com.wienerdev.sgtapireativa.api.tarefa.document.TarefaDTO;
import com.wienerdev.sgtapireativa.api.tarefa.repository.TarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementação dos métodos da Service da TarefaDTO
 * 
 * @author Matheus Nicolay Ulharuso Wiener
 * @version 1.0
 * @since 1.0
 */
@Service
public class TarefaImpl implements TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    /**
     * Busca todas as tarefas.
     * 
     * @return Flux< TarefaDTO >
     */
    @Override
    public Flux<TarefaDTO> findAll() {
        return tarefaRepository.findAll();
    }

    /**
     * Busca uma tarefa pelo ID.
     * 
     * @param id - String
     * @return Mono< TarefaDTO >
     */
    @Override
    public Mono<TarefaDTO> getById(String id) {
        return tarefaRepository.findById(id);
    }

    /**
     * Salva os dados de uma tarefa.
     * 
     * @param tarefa - TarefaDTO
     * @return Mono< TarefaDTO >
     */
    @Override
    public Mono<TarefaDTO> saveTarefa(TarefaDTO tarefa) {
        return tarefaRepository.save(tarefa);
    }

    /**
     * Deleta os dados de uma tarefa por ID.
     * 
     * @param id - String
     * @return Mono< TarefaDTO >
     */
    @Override
    public Mono<Void> deleteTarefaById(String id) {
        return tarefaRepository.deleteById(id);
    }

    /**
     * Altera os dados de uma tarefa por ID.
     * 
     * @param id - String
     * @param tarefa - TarefaDTO
     * @return Mono< TarefaDTO >
     */
    @Override
    public Mono<TarefaDTO> updateTarefaById(TarefaDTO tarefa) {
        return tarefaRepository.save(tarefa);
    }


    
}
