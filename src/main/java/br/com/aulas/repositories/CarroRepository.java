package br.com.aulas.repositories;

import br.com.aulas.entities.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity,Long > {

}
