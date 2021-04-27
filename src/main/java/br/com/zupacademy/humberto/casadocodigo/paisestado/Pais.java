package br.com.zupacademy.humberto.casadocodigo.paisestado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true) @NotBlank
	private String nome;
	
	public Pais(@Valid PaisForm paisForm) {
		this.nome = paisForm.getNome();
	}
	
	@Deprecated
	public Pais() {}
	
}
