package br.com.msp.findurbuddy.core.usecases.services;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.UpdateHomeRequest;
import br.com.msp.findurbuddy.core.usecases.port.in.UpdateHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.out.UpdateHomeOutputPort;

public class UpdateHomeService implements UpdateHomeCase {
    private final UpdateHomeOutputPort updateHomeOutputPort;

    public UpdateHomeService(UpdateHomeOutputPort updateHomeOutputPort) {
        this.updateHomeOutputPort = updateHomeOutputPort;
    }

    @Override
    public void execute(String homeId, UpdateHomeRequest request) {
        updateHomeOutputPort.update(homeId, request);
    }
}
