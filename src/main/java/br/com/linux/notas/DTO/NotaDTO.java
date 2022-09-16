package br.com.linux.notas.DTO;

import java.time.LocalDateTime;
import java.util.List;

import br.com.linux.notas.model.Nota;

public class NotaDTO {
	private String id;
	private String titulo;
	private String texto;
	private LocalDateTime dataCriacao;
	
	public NotaDTO(Nota nota) {
		this.id = nota.getId();
		this.titulo = nota.getTitulo();
		this.texto = nota.getTexto();
		this.dataCriacao = nota.getDataCriacao();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public static List<Nota> converter(List<Nota> notas) {
			return notas;	
			
		}
	
}
