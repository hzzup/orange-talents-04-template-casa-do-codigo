package br.com.zupacademy.humberto.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class CadastrarCliente {
	
	@Autowired
	ClienteRepository ClienteRep;
	
	@PersistenceContext
	EntityManager manager;

	@Autowired
	private VerificaSePaisTemEstado verificaSePaisTemEstado;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(verificaSePaisTemEstado);
	}

	@PostMapping
	public void cadastrar(@RequestBody @Valid ClienteRequest clienteReq) {
		Cliente cliente = clienteReq.converte(manager);
		ClienteRep.save(cliente);
	}
	
}
