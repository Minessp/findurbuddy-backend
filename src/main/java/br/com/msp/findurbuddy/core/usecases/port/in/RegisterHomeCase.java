package br.com.msp.findurbuddy.core.usecases.port.in;

import br.com.msp.findurbuddy.core.domain.Home;

public interface RegisterHomeCase {
    void execute(Home home);
}
