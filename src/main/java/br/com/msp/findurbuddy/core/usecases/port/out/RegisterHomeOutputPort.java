package br.com.msp.findurbuddy.core.usecases.port.out;

import br.com.msp.findurbuddy.adapter.output.persistence.entities.HomeEntity;

public interface RegisterHomeOutputPort {
    void register(HomeEntity homeEntity);
}
