package br.com.msp.findurbuddy.config.beans;

import br.com.msp.findurbuddy.adapter.input.mappers.HomeMapper;
import br.com.msp.findurbuddy.adapter.output.persistence.adapters.HomePersistenceAdapter;
import br.com.msp.findurbuddy.adapter.output.persistence.repositories.HomeRepository;
import br.com.msp.findurbuddy.core.usecases.port.in.DeleteHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.in.RegisterHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.in.UpdateHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.out.DeleteHomeOutputPort;
import br.com.msp.findurbuddy.core.usecases.port.out.RegisterHomeOutputPort;
import br.com.msp.findurbuddy.core.usecases.port.out.UpdateHomeOutputPort;
import br.com.msp.findurbuddy.core.usecases.services.DeleteHomeService;
import br.com.msp.findurbuddy.core.usecases.services.RegisterHomeService;
import br.com.msp.findurbuddy.core.usecases.services.UpdateHomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HomeBeans {
    @Bean
    public RegisterHomeCase registerHomeCase(RegisterHomeOutputPort registerHomeOutputPort) {
        return new RegisterHomeService(registerHomeOutputPort);
    }

    @Bean
    public RegisterHomeOutputPort registerHomeOutputPort(HomeRepository homeRepository, HomeMapper homeMapper) {
        return new HomePersistenceAdapter(homeRepository, homeMapper);
    }

    @Bean
    public DeleteHomeCase deleteHomeCase(DeleteHomeOutputPort deleteHomeOutputPort) {
        return new DeleteHomeService(deleteHomeOutputPort);
    }

    @Bean
    public DeleteHomeOutputPort deleteHomeOutputPort(HomeRepository homeRepository, HomeMapper homeMapper) {
        return new HomePersistenceAdapter(homeRepository, homeMapper);
    }

    @Bean
    public UpdateHomeCase updateHomeCase(UpdateHomeOutputPort updateHomeOutputPort) {
        return new UpdateHomeService(updateHomeOutputPort);
    }

    @Bean
    public UpdateHomeOutputPort updateHomeOutputPort(HomeRepository homeRepository, HomeMapper homeMapper) {
        return new HomePersistenceAdapter(homeRepository, homeMapper);
    }
}
