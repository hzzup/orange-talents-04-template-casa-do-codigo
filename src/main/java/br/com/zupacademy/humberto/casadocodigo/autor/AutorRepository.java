package br.com.zupacademy.humberto.casadocodigo.autor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long>{

	Optional<Autor> findByEmail(String email);
	
}
