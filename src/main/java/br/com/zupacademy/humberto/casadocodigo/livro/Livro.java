package br.com.zupacademy.humberto.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.humberto.casadocodigo.autor.Autor;
import br.com.zupacademy.humberto.casadocodigo.categoria.Categoria;

@Entity
public class Livro {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank @Column(unique=true)
	private String titulo;
	
	@NotBlank @Size(max=500)
	private String resumo;
	
	private String sumario;
	
	@NotNull @Min(value=20)
	private BigDecimal preco;
	
	@NotNull @Min(value=100)
	private int numeroPaginas;
	
	@NotBlank @Column(unique=true)
	private String isbn;
	
	@NotNull @JsonFormat(pattern="dd-MM-yyyy",shape=Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public Livro() {}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroPaginas, @NotBlank String isbn,
			@NotNull LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

}
