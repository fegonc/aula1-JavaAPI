package br.com.aulas.repositories;

import br.com.aulas.entities.CorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorRepository extends JpaRepository<CorEntity, Long> {
}
