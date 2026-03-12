package br.com.msp.findurbuddy.adapter.output.persistence.repositories;

import br.com.msp.findurbuddy.adapter.output.persistence.entities.HomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<HomeEntity, String> {
}
