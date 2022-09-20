package br.com.linux.notas.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.linux.notas.model.Nota;

public interface NotaRepository extends MongoRepository<Nota, ObjectId>{
	
		Optional<Nota> findById(ObjectId id);
		List<Nota> findAll();
		List<Nota> findByTitulo(String titulo);
		List<Nota> findByDataCriacao(String dataCriacao);
	}
