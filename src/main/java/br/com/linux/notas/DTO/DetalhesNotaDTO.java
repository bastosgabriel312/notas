package br.com.linux.notas.DTO;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

import br.com.linux.notas.model.Nota;

public class DetalhesNotaDTO {
	private String id;
	private String titulo;
	private String texto;
	private LocalDateTime dataCriacao;
	

	public DetalhesNotaDTO(Nota nota) {
		this.id = nota.getId();
		this.titulo = nota.getTitulo();
		this.texto = nota.getTexto();
		this.dataCriacao = nota.getDataCriacao();
	}
	public String getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getTexto() {
		return texto;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
}
