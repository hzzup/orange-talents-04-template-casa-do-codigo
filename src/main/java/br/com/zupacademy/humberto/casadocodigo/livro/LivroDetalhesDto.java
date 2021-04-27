package br.com.zupacademy.humberto.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zupacademy.humberto.casadocodigo.autor.AutorDto;

public class LivroDetalhesDto {

	private Long id;
	private String titulo;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private int numeroPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private AutorDto autorDto;
	
	@Deprecated
	public LivroDetalhesDto() {}

	public LivroDetalhesDto (Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.autorDto = new AutorDto(livro.getAutor());//livro.getAutor();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
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

	public AutorDto getAutorDto() {
		return autorDto;
	}
}
