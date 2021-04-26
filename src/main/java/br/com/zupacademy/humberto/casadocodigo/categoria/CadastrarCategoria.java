package br.com.zupacademy.humberto.casadocodigo.categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CadastrarCategoria {

	@Autowired
	private CategoriaRepository categoriaRep;
	
	//Validador do Spring
	//@Autowired
	//private ProibeNomeDuplicadoValidator proibeNomeDuplicadoValidator;
	
	//@InitBinder
	//public void init(WebDataBinder binder) {
	//	binder.addValidators(proibeNomeDuplicadoValidator);
	//}
	
	@PostMapping @Transactional
	public void cadastrar(@RequestBody @Valid CategoriaForm form) {
		Categoria categoria = form.criarAutor();
		categoriaRep.save(categoria);
	}
	
}

