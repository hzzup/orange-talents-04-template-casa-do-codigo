package br.com.zupacademy.humberto.casadocodigo.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeNomeDuplicadoValidator implements Validator{

	@Autowired
	private CategoriaRepository categoriaRep;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CategoriaForm form = (CategoriaForm) target;

		Optional<Categoria> possivelCategoria = categoriaRep.findByNome(form.getNome());

		if (possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null,"Nome já cadastrado!");
		}
		
	}
	
	
	
}
