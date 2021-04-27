package br.com.zupacademy.humberto.casadocodigo.livro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroDetalhesDto> listarPorId(@PathVariable long id) {
		Optional<Livro> livroOpt = livroRep.findById(id);
		if (livroOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new LivroDetalhesDto(livroOpt.get()));
	}
	
}
