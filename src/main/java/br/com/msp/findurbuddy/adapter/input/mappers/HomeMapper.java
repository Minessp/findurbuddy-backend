package br.com.msp.findurbuddy.adapter.input.mappers;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.RegisterHomeRequest;
import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.UpdateHomeRequest;
import br.com.msp.findurbuddy.adapter.output.persistence.entities.HomeEntity;
import br.com.msp.findurbuddy.core.domain.Home;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder( disableBuilder = true ))
public interface HomeMapper {
    HomeEntity domainToEntity(Home domain);
    Home entityToDomain(HomeEntity entity);
    void updateEntity(UpdateHomeRequest request, @MappingTarget HomeEntity entity);
    Home registerHomeRequestToDomain(RegisterHomeRequest request);
}
