package br.com.linux.notas.form;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import br.com.linux.notas.model.Nota;

public class NotaForm {
	@NonNull
	private String titulo;
	@NonNull
	private String texto;
	@NonNull
	private LocalDateTime dataCriacao;
	
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
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Nota converter() {
		return new Nota(titulo,texto);
	}
	
}
