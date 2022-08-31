package br.com.linux.notas.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.linux.notas.DTO.DetalhesNotaDTO;
import br.com.linux.notas.DTO.NotaDTO;
import br.com.linux.notas.form.AtualizacaoNotaForm;
import br.com.linux.notas.form.NotaForm;
import br.com.linux.notas.model.Nota;
import br.com.linux.notas.repository.NotaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Nota")
@RequestMapping("/notas")
public class NotaController {
	
	@Autowired
	public NotaRepository repository;
	
	
	@GetMapping
	@ApiOperation(value = "Mostra lista de anotações")
	public Page<NotaDTO> listar(@RequestParam(required = false) String titulo,
			@RequestParam(required = false) String dataCriacao,
			@PageableDefault(sort = "id", direction = Direction.ASC) Pageable paginacao){
		
		if (titulo==null) {
			Page<Nota> notas = repository.findAll(paginacao);
			return NotaDTO.converter(notas);
		} else {
			Page<Nota> notas = repository.findByTitulo(titulo,paginacao);
			return NotaDTO.converter(notas);
		}
	}
	
	@PostMapping
	@Transactional
	@ApiOperation(value = "Cria uma nova nota")
	public ResponseEntity<NotaDTO> criar(@Validated @RequestBody NotaForm notaForm, UriComponentsBuilder uriBuilder) {
		Nota nota = notaForm.converter();
		repository.save(nota);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(nota.getId()).toUri();
		return ResponseEntity.created(uri).body(new NotaDTO(nota));

	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Mostra detalhes de uma nota")
	public ResponseEntity<DetalhesNotaDTO> detalhar(@PathVariable Long id) {
		Optional<Nota> nota = repository.findById(id);
		if (nota.isPresent()) {
			return ResponseEntity.ok(new DetalhesNotaDTO(nota.get()));
		}
		return ResponseEntity.notFound().build();

	}
	
	@PutMapping("/{id}")
	@Transactional
	@ApiOperation(value = "Atualiza uma anotação")
	public ResponseEntity<NotaDTO> atualizar(@PathVariable Long id,
			@RequestBody @Validated AtualizacaoNotaForm notaForm) {
		Optional<Nota> nota = repository.findById(id);
		if (nota.isPresent()) {
			Nota notaAtualizada = notaForm.atualizar(id, repository);
			return ResponseEntity.ok(new NotaDTO(notaAtualizada));
		}
		return ResponseEntity.notFound().build();

	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@ApiOperation(value = "Remove uma nota")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Nota> nota = repository.findById(id);
		if (nota.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}
	
	
}
