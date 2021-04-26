package br.com.zupacademy.humberto.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
	
	@NotBlank
	private String nome;

	public CategoriaForm(@NotBlank String nome) {
		this.nome = nome;
	}
	
	@Deprecated
	public CategoriaForm() {}

	public Categoria criarAutor() {
		return new Categoria(nome);
	}

	public String getNome() {
		return nome;
	}

}
