package br.com.msp.findurbuddy.core.usecases.port.in;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.RegisterHomeRequest;

public interface RegisterHomeCase {
    void execute(RegisterHomeRequest request);
}
