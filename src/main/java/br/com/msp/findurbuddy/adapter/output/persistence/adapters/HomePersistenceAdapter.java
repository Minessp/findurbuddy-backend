package br.com.msp.findurbuddy.adapter.output.persistence.adapters;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.UpdateHomeRequest;
import br.com.msp.findurbuddy.adapter.input.mappers.HomeMapper;
import br.com.msp.findurbuddy.adapter.output.persistence.entities.HomeEntity;
import br.com.msp.findurbuddy.adapter.output.persistence.repositories.HomeRepository;
import br.com.msp.findurbuddy.core.domain.Home;
import br.com.msp.findurbuddy.core.usecases.port.out.DeleteHomeOutputPort;
import br.com.msp.findurbuddy.core.usecases.port.out.RegisterHomeOutputPort;
import br.com.msp.findurbuddy.core.usecases.port.out.UpdateHomeOutputPort;

public class HomePersistenceAdapter implements RegisterHomeOutputPort, DeleteHomeOutputPort, UpdateHomeOutputPort {
    private final HomeRepository homeRepository;
    private final HomeMapper homeMapper;

    public HomePersistenceAdapter(HomeRepository homeRepository, HomeMapper homeMapper) {
        this.homeRepository = homeRepository;
        this.homeMapper = homeMapper;
    }

    @Override
    public void register(Home home) {
        if (homeRepository.existsByName(home.name()))
            throw new IllegalArgumentException("Home with the same name already exists.");

        if (homeRepository.existsByAddress(home.address()))
            throw new IllegalArgumentException("Home with the same address already exists.");

        homeRepository.save(homeMapper.domainToEntity(home));
    }

    @Override
    public void delete(String homeId) {
        if (homeId == null || homeId.isBlank()) {
            throw new IllegalArgumentException("Enter a valid home id.");
        }

        if (!homeRepository.existsById(homeId))
            throw new IllegalArgumentException("Home not found.");

        homeRepository.deleteById(homeId);
    }

    @Override
    public void update(String homeId, UpdateHomeRequest request) {
        if (homeId == null || homeId.isBlank()) {
            throw new IllegalArgumentException("Enter a valid home id.");
        }

        if (!homeRepository.existsById(homeId))
            throw new IllegalArgumentException("Home not found.");

        HomeEntity homeEntity = homeRepository.findHomeEntityById(homeId);

        try {
            homeMapper.updateEntity(request, homeEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error updating home");
        }

        homeRepository.save(homeEntity);
    }
}
