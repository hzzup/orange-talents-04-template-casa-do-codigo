package br.com.zupacademy.humberto.casadocodigo.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class VerificaSePaisTemEstado implements Validator{
	
	@PersistenceContext
	EntityManager manager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		//nessa primeira query verificamos se o pais possui estados associados
		ClienteRequest form = (ClienteRequest) target;
		Query query = manager.createQuery("select 1 from Estado where pais.id=:value");
		query.setParameter("value", form.getPaisId());
		List<?> list = query.getResultList();


		//na nossa segunda query verificamos se aquele estado está associado ao pais passado
		if (list.size() >= 1) {
			query = manager.createQuery("select 1 from Estado where pais.id=:value and id=:value_estado");
			query.setParameter("value", form.getPaisId());
			query.setParameter("value_estado", form.getEstadoId());
			list = query.getResultList();
			if(list .size() == 0) {
				errors.rejectValue("paisId", null,"Pais Id:"+form.getPaisId()+" não possui o estado id:"+form.getEstadoId()+" cadastrado!");
			}
		} else {
			//aqui verificamos se o usuario passou um id de estado para um pais que não possui estados
			if (form.getEstadoId() != null) {
				errors.rejectValue("paisId", null, "Pais Id:" + form.getPaisId() + " não possui estados cadastrados!");
			}
		}
	}
}
