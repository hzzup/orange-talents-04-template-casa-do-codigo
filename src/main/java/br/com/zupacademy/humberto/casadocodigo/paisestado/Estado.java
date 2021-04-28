package br.com.zupacademy.humberto.casadocodigo.paisestado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@NotBlank
	private String nome;
	
	@ManyToOne @NotNull
	private Pais pais;
	
	public Estado(@NotBlank String nomeEstado, Pais paisDoEstado) {
		this.nome = nomeEstado;
		this.pais = paisDoEstado;
	}
	
	@Deprecated
	public Estado() {}

	public String getNome() {
		return nome;
	}
	
}
