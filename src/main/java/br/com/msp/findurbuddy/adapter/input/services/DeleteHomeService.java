package br.com.msp.findurbuddy.adapter.input.services;

import br.com.msp.findurbuddy.adapter.output.persistence.repositories.HomeRepository;
import br.com.msp.findurbuddy.core.usecases.port.in.DeleteHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.out.DeleteHomeOutputPort;

public class DeleteHomeService implements DeleteHomeCase {
    private final DeleteHomeOutputPort deleteHomeOutputPort;
    private final HomeRepository homeRepository;

    public DeleteHomeService(DeleteHomeOutputPort deleteHomeOutputPort, HomeRepository homeRepository) {
        this.deleteHomeOutputPort = deleteHomeOutputPort;
        this.homeRepository = homeRepository;
    }

    @Override
    public void execute(String homeId) {
        if (homeId == null || homeId.isBlank()) {
            throw new IllegalArgumentException("Enter a valid home id.");
        }

        if (!homeRepository.existsById(homeId))
            throw new IllegalArgumentException("Home not found.");

        deleteHomeOutputPort.delete(homeId);
    }
}
