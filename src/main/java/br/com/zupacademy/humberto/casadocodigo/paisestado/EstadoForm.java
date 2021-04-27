package br.com.zupacademy.humberto.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EstadoForm {
	
	@NotBlank
	private String nome;
	
	@NotNull
	private Long paisId;

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Estado converte(EntityManager manager) {
		Pais pais = manager.find(Pais.class, paisId);
		if (pais == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		//Assert.notNull(pais,"Pais não encontrado!");
		
		return new Estado(nome,pais);
	}
}
