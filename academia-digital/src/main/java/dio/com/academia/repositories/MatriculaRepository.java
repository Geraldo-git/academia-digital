package dio.com.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.com.academia.entities.AvaliacaoFisica;

@Repository
public interface MatriculaRepository extends JpaRepository<AvaliacaoFisica, Long>{

}
