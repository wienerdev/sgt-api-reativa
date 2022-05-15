package com.wienerdev.sgtapireativa.api.tarefa.repository;

import com.wienerdev.sgtapireativa.api.tarefa.document.TarefaDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Repository da tarefa para acesso aos métodos REST.
 * 
 * @author Matheus Nicolay Ulharuso Wiener
 * @version 1.0
 * @since 1.0
 */
public interface TarefaRepository extends ReactiveMongoRepository<TarefaDTO, String>  {

}
