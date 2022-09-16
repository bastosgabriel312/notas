package br.com.linux.notas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.linux.notas.model.Nota;

public interface NotaRepository extends MongoRepository<Nota, String>{
	
		Optional<Nota> findById(String id);
		List<Nota> findAll();
		List<Nota> findByTitulo(String titulo);
		List<Nota> findByDataCriacao(String dataCriacao);
	}
