package br.com.zupacademy.humberto.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Autor {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private LocalDateTime dataRegistro = LocalDateTime.now();
	
	@Email @NotBlank @Column(unique=true)
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank @Size(min=1,max=400)
	private String descricao;

	public Autor(@Email @NotBlank String email, @NotBlank String nome,
			@NotBlank @Size(min = 1, max = 400) String descricao) {
		if(nome.equals("") || nome.trim().equals("") || nome == null) {
			throw new IllegalArgumentException("Nome é obrigatório");
		}
		if(email.equals("") || email.trim().equals("") || email == null) {
			throw new IllegalArgumentException("Email é obrigatório");
		}
		if(descricao.equals("") || descricao.trim().equals("") || descricao == null) {
			throw new IllegalArgumentException("Descrição é obrigatório");
		}
		if (descricao.length() > 400) {
			throw new IllegalArgumentException("Descrição deve ser menor que 400 caracteres");
		}
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
	}

	@Deprecated
	public Autor() {}
}
