package br.com.zupacademy.humberto.casadocodigo.autor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator{

	@Autowired
	AutorRepository autorRep;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AutorForm form = (AutorForm) target;

		Optional<Autor> possivelAutor = autorRep.findByEmail(form.getEmail());

		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null,"Email já cadastrado!");
		}
	}

}
