package br.com.zupacademy.humberto.casadocodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class CadastrarAutor {

	@Autowired
	private AutorRepository autorRep;
	
	@PostMapping @Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorForm autorForm) {
		Autor autor = autorForm.criarAutor(autorRep);
		if (autor == null) {
			return ResponseEntity.badRequest().build();
			
		}
		autorRep.save(autor);
		return ResponseEntity.ok().build();	
	}
	
}
