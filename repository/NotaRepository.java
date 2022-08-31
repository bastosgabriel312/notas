package br.com.linux.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.linux.notes.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long>{
	
	}
