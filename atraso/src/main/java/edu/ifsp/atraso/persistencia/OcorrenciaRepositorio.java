package edu.ifsp.atraso.persistencia;

import org.springframework.data.repository.CrudRepository;

import edu.ifsp.atraso.modelo.Ocorrencia;

public interface OcorrenciaRepositorio extends CrudRepository<Ocorrencia, Integer> {
	
}