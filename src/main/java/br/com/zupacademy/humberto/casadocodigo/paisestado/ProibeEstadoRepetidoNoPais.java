package br.com.zupacademy.humberto.casadocodigo.paisestado;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEstadoRepetidoNoPais implements Validator{

	@Autowired
	EstadoRepository estadoRep;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return EstadoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		EstadoForm form = (EstadoForm) target;

		Optional<Estado> possivelEstado = estadoRep.findByNomeAndPaisId(form.getNome(),form.getPaisId());

		if (possivelEstado.isPresent()) {
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			errors.rejectValue("paisId", null,"Pais Id:"+form.getPaisId()+" já possui o estado "+form.getNome()+" cadastrado!");
		}
	}

	
	
}
