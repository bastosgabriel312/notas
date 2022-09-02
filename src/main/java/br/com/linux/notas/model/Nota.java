package br.com.linux.notas.model;

import java.time.LocalDateTime;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notas")
public class Nota {
	
	@Id
	private String id;
	private String titulo;
	private String texto;
	private LocalDateTime dataCriacao = LocalDateTime.now() ;
	
	public Nota() {};
	
	
	public Nota(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getId() {
		return id;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
