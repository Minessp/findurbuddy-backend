package br.com.msp.findurbuddy.core.usecases.services;

import br.com.msp.findurbuddy.core.usecases.port.in.DeleteHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.out.DeleteHomeOutputPort;

public class DeleteHomeService implements DeleteHomeCase {
    private final DeleteHomeOutputPort deleteHomeOutputPort;

    public DeleteHomeService(DeleteHomeOutputPort deleteHomeOutputPort) {
        this.deleteHomeOutputPort = deleteHomeOutputPort;
    }

    @Override
    public void execute(String homeId) {
        deleteHomeOutputPort.delete(homeId);
    }
}
