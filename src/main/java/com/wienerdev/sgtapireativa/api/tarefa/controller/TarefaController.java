package com.wienerdev.sgtapireativa.api.tarefa.controller;

import java.time.Duration;

import com.wienerdev.sgtapireativa.api.tarefa.document.TarefaDTO;
import com.wienerdev.sgtapireativa.api.tarefa.service.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

/**
 * Controller implementando os endpoints do objeto Tarefa.
 * OBS: Para utilizar essa controller, comente o @Bean e @Configuration da classe TarefaRouter
 * 
 * @author Matheus Nicolay Ulharuso Wiener
 * @version 1.0
 * @since 1.0
 */
// @RestController
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    /**
     * Exemplo de endpoint permite consultar todas as tarefas com Stream de Eventos (GET).
     * @return Flux< TarefaDTO >
     */
    @GetMapping(value = "/tarefas/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, TarefaDTO>> getAllTarefasEvents() {
        return Flux.zip(Flux.interval(Duration.ofSeconds(10)), tarefaService.findAll());
    }

    /**
     * Este endpoint permite consultar todas as tarefas (GET).
     * @return Flux< TarefaDTO >
     */
    @GetMapping(value = "/tarefas")
    public Flux<TarefaDTO> findAllTarefas() {
        return tarefaService.findAll();
    }

    /**
     * Este endpoint permite consultar uma tarefa por ID (GET).
     * @param id - String
     * @return Mono< TarefaDTO >
     */
    @GetMapping(value = "/tarefas/{id}")
    public Mono<TarefaDTO> getTarefaById(@PathVariable String id) {
        return tarefaService.getById(id);
    }

    /**
     * Este endpoint permite deletar uma tarefa por ID (DELETE).
     * @param id - String
     * @return Mono< Void >
     */
    @DeleteMapping(value = "/deleteTarefa/{id}")
    public Mono<Void> deleteTarefaById(@PathVariable String id) {
        return tarefaService.deleteTarefaById(id);
    }   

    /**
     * Este endpoint permite alterar uma tarefa por ID (PUT).
     * @param tarefa - TarefaDTO
     * @return Mono< TarefaDTO >
     */
    @PutMapping(value = "/updateTarefa/{id}")
    public Mono<TarefaDTO> updateTarefaById(@RequestBody TarefaDTO tarefa) {
        return tarefaService.updateTarefaById(tarefa);
    }

    
    /**
     * Este endpoint permite criar uma tarefa (POST).
     * @param tarefa - TarefaDTO
     * @return Mono< TarefaDTO >
     */
    @PostMapping(value = "/saveTarefa")
    public Mono<TarefaDTO> saveTarefa(@RequestBody TarefaDTO tarefa) {
        return tarefaService.saveTarefa(tarefa);
    }





}
