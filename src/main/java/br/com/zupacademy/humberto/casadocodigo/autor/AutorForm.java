package br.com.zupacademy.humberto.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.humberto.casadocodigo.validacao.UniqueValue;

public class AutorForm {
	
	@Email @NotBlank
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
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
		Autor autorCriado = new Autor(email,nome,descricao);
		return autorCriado;
	}

	public String getEmail() {
		return email;
	}
	
}
