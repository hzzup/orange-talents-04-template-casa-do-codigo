package br.com.zupacademy.humberto.casadocodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class CadastrarAutor {

	@Autowired
	private AutorRepository autorRep;
	
	//Validador do Spring
	//@Autowired
	//private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	//@InitBinder
	//public void init(WebDataBinder binder) {
	//	binder.addValidators(proibeEmailDuplicadoAutorValidator);
	//}
	
	@PostMapping @Transactional
	public void cadastrar(@RequestBody @Valid AutorForm autorForm) {
		Autor autor = autorForm.criarAutor();
		autorRep.save(autor);
	}
	
}
