package br.com.zupacademy.humberto.casadocodigo.paisestado;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado,Long>{

	Optional<Estado> findByNomeAndPaisId(String nome, Long paisId);

}
