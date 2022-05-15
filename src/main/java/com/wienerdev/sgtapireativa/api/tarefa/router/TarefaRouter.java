package com.wienerdev.sgtapireativa.api.tarefa.router;

import com.wienerdev.sgtapireativa.api.tarefa.handler.TarefaHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class TarefaRouter {

    @Bean
    public RouterFunction<ServerResponse> route(TarefaHandler handler) {
        return RouterFunctions
                    .route(GET("/tarefas").and(accept(MediaType.APPLICATION_JSON)), handler::findAllHand)
                    .andRoute(GET("/tarefas/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findByIdHand)
                    .andRoute(DELETE("/deleteTarefa/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::deleteByIdHand)
                    .andRoute(PUT("/updateTarefa/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::updateByIdHand)
                    .andRoute(POST("/saveTarefa").and(accept(MediaType.APPLICATION_JSON)), handler::saveHand);
    }
    
}
