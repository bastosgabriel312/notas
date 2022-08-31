package br.com.linux.notas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.linux.notas.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long>{
		
		Page<Nota> findByTitulo(String titulo,Pageable paginacao);
		Page<Nota> findByDataCriacao(String dataCriacao, Pageable paginacao);
	}
