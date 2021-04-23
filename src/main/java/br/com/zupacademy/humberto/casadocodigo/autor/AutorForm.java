package br.com.zupacademy.humberto.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {
	
	@Email @NotBlank
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank @Size(min=1,max=400)
	private String descricao;	

	public AutorForm(@Email @NotBlank String email, @NotBlank String nome,
			@NotBlank @Size(min = 1, max = 400) String descricao) {
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Autor criarAutor() {
		Autor autor = new Autor(email,nome,descricao);
		return autor;
	}
}
