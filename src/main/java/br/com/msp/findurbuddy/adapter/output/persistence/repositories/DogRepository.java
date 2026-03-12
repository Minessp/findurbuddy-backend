package br.com.msp.findurbuddy.adapter.output.persistence.repositories;

import br.com.msp.findurbuddy.adapter.output.persistence.entities.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<DogEntity, String> {
}
