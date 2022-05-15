package com.wienerdev.sgtapireativa.api.tarefa.controller;

import com.wienerdev.sgtapireativa.api.tarefa.document.TarefaDTO;
import com.wienerdev.sgtapireativa.api.tarefa.service.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @GetMapping(value = "/tarefas")
    public Flux<TarefaDTO> findAllTarefas() {
        return tarefaService.findAll();
    }

    @GetMapping(value = "/tarefas/{id}")
    public Mono<TarefaDTO> getTarefaById(@PathVariable String id) {
        return tarefaService.getById(id);
    }

    @DeleteMapping(value = "/deleteTarefa/{id}")
    public Mono<Void> deleteTarefaById(@PathVariable String id) {
        return tarefaService.deleteTarefaById(id);
    }   

    @PutMapping(value = "/updateTarefa")
    public Mono<TarefaDTO> updateTarefaById(@PathVariable String id, TarefaDTO tarefa) {
        return tarefaService.updateTarefaById(id, tarefa);
    }

    @PostMapping(value = "/saveTarefa", consumes = "*/*")
    public Mono<TarefaDTO> saveTarefa(@RequestBody TarefaDTO tarefa) {
        return tarefaService.saveTarefa(tarefa);
    }





}
