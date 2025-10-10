package br.com.aulas.repositories;

import br.com.aulas.entities.CarroEntity;
import br.com.aulas.entities.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity,Long > {
}
