package br.com.linux.notas.form;

import java.util.Optional;

import br.com.linux.notas.model.Nota;
import br.com.linux.notas.repository.NotaRepository;

public class AtualizacaoNotaForm {
	private String titulo;
	private String texto;
	
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
	public Nota atualizar(Long id, NotaRepository repository) {
		Nota nota = repository.findById(id).get();
			nota.setTexto(this.texto);
			nota.setTitulo(this.titulo);
		return nota;
	}
	
	
}
