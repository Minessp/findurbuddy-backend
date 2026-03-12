package br.com.msp.findurbuddy.adapter.input.mappers;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.RegisterHomeRequest;
import br.com.msp.findurbuddy.adapter.output.persistence.entities.HomeEntity;

public class HomeDtoMapper {
    public static HomeEntity registerRequestToEntity(RegisterHomeRequest request) {
        return new HomeEntity(
                request.name(),
                request.description(),
                request.address(),
                request.city(),
                request.state(),
                request.phone()
        );
    }
}
