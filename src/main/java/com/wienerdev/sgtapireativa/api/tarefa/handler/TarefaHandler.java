package com.wienerdev.sgtapireativa.api.tarefa.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.wienerdev.sgtapireativa.api.tarefa.document.TarefaDTO;
import com.wienerdev.sgtapireativa.api.tarefa.service.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * Handler dos endpoints do objeto Tarefa.
 * 
 * @author Matheus Nicolay Ulharuso Wiener
 * @version 1.0
 * @since 1.0
 */
@Component
public class TarefaHandler {

    @Autowired
    TarefaService tarefaService;

    public Mono<ServerResponse> findAllHand(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(tarefaService.findAll(), TarefaDTO.class);
    }

    public Mono<ServerResponse> findByIdHand(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(tarefaService.getById(id), TarefaDTO.class);
    }

    public Mono<ServerResponse> deleteByIdHand(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(tarefaService.deleteTarefaById(id), TarefaDTO.class);
    }

    public Mono<ServerResponse> updateByIdHand(ServerRequest request) {
        final Mono<TarefaDTO> tarefa = request.bodyToMono(TarefaDTO.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(tarefa.flatMap(tarefaService::updateTarefaById), TarefaDTO.class));
    }

    public Mono<ServerResponse> saveHand(ServerRequest request) {
        final Mono<TarefaDTO> tarefa = request.bodyToMono(TarefaDTO.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(tarefa.flatMap(tarefaService::saveTarefa), TarefaDTO.class));
    }
    
}
