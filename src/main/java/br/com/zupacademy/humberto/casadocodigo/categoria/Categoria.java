package br.com.zupacademy.humberto.casadocodigo.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank @Column(unique=true)
	private String nome;
	
	@Deprecated
	public Categoria() {}

	public Categoria(@NotBlank String nome) {
		if(nome.equals("") || nome.trim().equals("") || nome == null) {
			throw new IllegalArgumentException("Nome é obrigatório");
		}
		this.nome = nome;
	}

}
