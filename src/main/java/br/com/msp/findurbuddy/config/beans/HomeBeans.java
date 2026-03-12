package br.com.msp.findurbuddy.config.beans;

import br.com.msp.findurbuddy.adapter.output.persistence.adapters.HomePersistenceAdapter;
import br.com.msp.findurbuddy.adapter.output.persistence.repositories.HomeRepository;
import br.com.msp.findurbuddy.core.usecases.port.in.RegisterHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.out.RegisterHomeOutputPort;
import br.com.msp.findurbuddy.core.usecases.services.RegisterHomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HomeBeans {
    @Bean
    public RegisterHomeCase registerHomeCase(RegisterHomeOutputPort registerHomeOutputPort) {
        return new RegisterHomeService(registerHomeOutputPort);
    }

    @Bean
    public RegisterHomeOutputPort registerHomeOutputPort(HomeRepository homeRepository) {
        return new HomePersistenceAdapter(homeRepository);
    }
}
