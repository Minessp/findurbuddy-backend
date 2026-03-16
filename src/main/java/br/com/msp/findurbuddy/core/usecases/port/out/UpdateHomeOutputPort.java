package br.com.msp.findurbuddy.core.usecases.port.out;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.UpdateHomeRequest;

public interface UpdateHomeOutputPort {
    void update(String homeId, UpdateHomeRequest request);
}
