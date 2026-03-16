package br.com.msp.findurbuddy.core.usecases.port.in;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.UpdateHomeRequest;

public interface UpdateHomeCase {
    void execute(String homeId, UpdateHomeRequest request);
}
