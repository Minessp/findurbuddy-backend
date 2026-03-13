package br.com.msp.findurbuddy.adapter.input.services;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.RegisterHomeRequest;
import br.com.msp.findurbuddy.adapter.input.mappers.HomeDtoMapper;
import br.com.msp.findurbuddy.adapter.output.persistence.repositories.HomeRepository;
import br.com.msp.findurbuddy.core.exceptions.ExistingEntityException;
import br.com.msp.findurbuddy.core.usecases.port.in.RegisterHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.out.RegisterHomeOutputPort;

public class RegisterHomeService implements RegisterHomeCase {
    private final RegisterHomeOutputPort registerHomeOutputPort;
    private final HomeRepository homeRepository;

    public RegisterHomeService(RegisterHomeOutputPort registerHomeOutputPort, HomeRepository homeRepository) {
        this.registerHomeOutputPort = registerHomeOutputPort;
        this.homeRepository = homeRepository;
    }

    @Override
    public void execute(RegisterHomeRequest request) {
        if (homeRepository.existsByName(request.name()))
            throw new ExistingEntityException("Home with the same name already exists.");

        if (homeRepository.existsByAddress(request.address()))
            throw new ExistingEntityException("Home with the same address already exists.");

        registerHomeOutputPort.register(HomeDtoMapper.registerRequestToEntity(request));
    }
}
