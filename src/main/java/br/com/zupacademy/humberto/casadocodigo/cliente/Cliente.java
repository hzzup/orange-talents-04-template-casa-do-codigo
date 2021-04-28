package br.com.zupacademy.humberto.casadocodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.zupacademy.humberto.casadocodigo.paisestado.Estado;
import br.com.zupacademy.humberto.casadocodigo.paisestado.Pais;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Email @NotBlank @Column(unique=true)
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@CPF @NotBlank @Column(unique=true)
	private String cpf;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull @ManyToOne
	private Pais pais;
	@ManyToOne
	private Estado estado;
	@Size(min=8,max=12)
	private String telefone;
	@Size(min=8,max=8)
	private String cep;
	
	public Cliente(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@CPF @NotBlank String cpf, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Pais pais, @NotNull Estado estado, @Size(min = 8, max = 12) String telefone,
			@Size(min = 8, max = 8) String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
}
