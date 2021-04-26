package br.com.zupacademy.humberto.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class CadastrarLivro {

	@Autowired
	private LivroRepository livroRep;
	
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping @Transactional
	public void cadastrar(@RequestBody @Valid LivroForm form) {
		Livro livro = form.converter(manager);
		livroRep.save(livro);
	}
}
