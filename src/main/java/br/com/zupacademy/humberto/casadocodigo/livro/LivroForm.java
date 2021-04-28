package br.com.zupacademy.humberto.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.humberto.casadocodigo.autor.Autor;
import br.com.zupacademy.humberto.casadocodigo.categoria.Categoria;
import br.com.zupacademy.humberto.casadocodigo.validacao.FindObjectId;
import br.com.zupacademy.humberto.casadocodigo.validacao.UniqueValue;

public class LivroForm {

	
	@NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank @Size(max=500)
	private String resumo;
	
	private String sumario;
	
	@NotNull @Min(value=20)
	private BigDecimal preco;
	
	@NotNull @Min(value=100)
	private int numeroPaginas;
	
	@NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	
	@NotNull @JsonFormat(pattern="dd-MM-yyyy",shape=Shape.STRING) @Future
	private LocalDate dataPublicacao;
	
	@NotNull @FindObjectId(domainClass = Categoria.class, fieldName = "id")
	private Long categoriaId;
	
	@NotNull @FindObjectId(domainClass = Autor.class, fieldName = "id")
	private Long autorId;

	public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroPaginas, @NotBlank String isbn,
			@NotNull Long categoriaId, @NotNull Long autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		//this.dataPublicacao = dataPublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}

	public Livro converter(EntityManager manager) {
		Autor autor = manager.find(Autor.class, autorId);
		Categoria categoria = manager.find(Categoria.class, categoriaId);
		Assert.notNull(autor,"Autor não encontrado");
		Assert.notNull(categoria,"Categoria não encontrada");
		return new Livro(titulo,resumo,sumario,preco,numeroPaginas,isbn,dataPublicacao,categoria,autor);
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
}
