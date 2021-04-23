package br.com.zupacademy.humberto.casadocodigo.autor;

import java.time.LocalDateTime;

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
	
	@Email @NotBlank
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank @Size(min=1,max=400)
	private String descricao;


	
	public Autor(@Email @NotBlank String email, @NotBlank String nome,
			@NotBlank @Size(min = 1, max = 400) String descricao) {
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
	}



	@Deprecated
	public Autor() {}
	

}
