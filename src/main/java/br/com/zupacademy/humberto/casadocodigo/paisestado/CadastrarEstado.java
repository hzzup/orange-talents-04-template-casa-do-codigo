package br.com.zupacademy.humberto.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class CadastrarEstado {
	@Autowired
	EstadoRepository estadoRep;
	
	@PersistenceContext
	EntityManager manager;

	@Autowired
	private ProibeEstadoRepetidoNoPais proibeEstadoRepetidoNoPais;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEstadoRepetidoNoPais);
	}

	@PostMapping @Transactional
	public void cadastrar(@RequestBody @Valid EstadoForm estadoForm) {
		Estado estado = estadoForm.converte(manager);
		estadoRep.save(estado);
	}
}
