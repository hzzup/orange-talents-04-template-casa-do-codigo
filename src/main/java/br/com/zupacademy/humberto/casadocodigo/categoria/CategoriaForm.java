package br.com.zupacademy.humberto.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.humberto.casadocodigo.validacao.UniqueValue;

public class CategoriaForm {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
