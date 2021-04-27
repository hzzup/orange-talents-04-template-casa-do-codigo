package br.com.zupacademy.humberto.casadocodigo.paisestado;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.humberto.casadocodigo.validacao.UniqueValue;

public class PaisForm {
	
	@NotBlank @UniqueValue(domainClass=Pais.class,fieldName="nome")
	private String nome;

	public PaisForm(@NotBlank String nome) {
		this.nome = nome;
	}
	
	@Deprecated
	public PaisForm() {}

	public String getNome() {
		return nome;
	}
}
