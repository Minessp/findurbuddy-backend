package br.com.msp.findurbuddy.core.usecases.services;

import br.com.msp.findurbuddy.core.domain.Home;
import br.com.msp.findurbuddy.core.usecases.port.in.RegisterHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.out.RegisterHomeOutputPort;

public class RegisterHomeService implements RegisterHomeCase {
    private final RegisterHomeOutputPort registerHomeOutputPort;

    public RegisterHomeService(RegisterHomeOutputPort registerHomeOutputPort) {
        this.registerHomeOutputPort = registerHomeOutputPort;
    }

    @Override
    public void execute(Home home) {
        registerHomeOutputPort.register(home);
    }
}
