package br.com.linux.notas.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.linux.notas.model.Nota;

public interface NotaRepository extends MongoRepository<Nota, Long>{
	
		Optional<Nota> findById(String id);
		Page<Nota> findAll(Pageable paginacao);
		Page<Nota> findByTitulo(String titulo,Pageable paginacao);
		Page<Nota> findByDataCriacao(String dataCriacao, Pageable paginacao);
	}
