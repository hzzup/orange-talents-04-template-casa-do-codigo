package br.com.zupacademy.humberto.casadocodigo.paisestado;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class CadastrarPais {
	
	@Autowired
	PaisRepository paisRep;

	@PostMapping @Transactional
	public void cadastrar(@RequestBody @Valid PaisForm paisForm) {
		Pais pais = new Pais(paisForm);
		paisRep.save(pais);
	}
	
}
