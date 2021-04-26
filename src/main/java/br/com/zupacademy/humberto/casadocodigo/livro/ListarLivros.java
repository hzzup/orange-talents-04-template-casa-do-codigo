package br.com.zupacademy.humberto.casadocodigo.livro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class ListarLivros {

	@Autowired
	private LivroRepository livroRep;

	@GetMapping
	public List<LivroDto> listar() {
		List<Livro> listaDeLivros = livroRep.findAll();
		
		return LivroDto.converte(listaDeLivros);
	}
}
