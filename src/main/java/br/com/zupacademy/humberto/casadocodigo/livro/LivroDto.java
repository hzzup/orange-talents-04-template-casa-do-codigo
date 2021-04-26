package br.com.zupacademy.humberto.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroDto {

	private String titulo;
	private Long id;
	
	@Deprecated
	public LivroDto() {}
	
	public LivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.id = livro.getId();
	}

	public static List<LivroDto> converte(List<Livro> listaDeLivros) {
		return listaDeLivros.stream().map(LivroDto::new).collect(Collectors.toList());
	}

	public String getTitulo() {
		return titulo;
	}

	public Long getId() {
		return id;
	}
	
}
