package br.com.msp.findurbuddy.adapter.output.persistence.adapters;

import br.com.msp.findurbuddy.adapter.output.persistence.entities.HomeEntity;
import br.com.msp.findurbuddy.adapter.output.persistence.repositories.HomeRepository;
import br.com.msp.findurbuddy.core.usecases.port.out.RegisterHomeOutputPort;

public class HomePersistenceAdapter implements RegisterHomeOutputPort {
    private final HomeRepository homeRepository;

    public HomePersistenceAdapter(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Override
    public void register(HomeEntity homeEntity) {
        homeRepository.save(homeEntity);
    }
}
