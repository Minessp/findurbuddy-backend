package br.com.msp.findurbuddy.config.beans;

import br.com.msp.findurbuddy.adapter.output.persistence.adapters.HomePersistenceAdapter;
import br.com.msp.findurbuddy.adapter.output.persistence.repositories.HomeRepository;
import br.com.msp.findurbuddy.core.usecases.port.in.DeleteHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.in.RegisterHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.out.DeleteHomeOutputPort;
import br.com.msp.findurbuddy.core.usecases.port.out.RegisterHomeOutputPort;
import br.com.msp.findurbuddy.adapter.input.services.DeleteHomeService;
import br.com.msp.findurbuddy.adapter.input.services.RegisterHomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HomeBeans {
    @Bean
    public RegisterHomeCase registerHomeCase(RegisterHomeOutputPort registerHomeOutputPort,
                                             HomeRepository homeRepository) {
        return new RegisterHomeService(registerHomeOutputPort, homeRepository);
    }

    @Bean
    public RegisterHomeOutputPort registerHomeOutputPort(HomeRepository homeRepository) {
        return new HomePersistenceAdapter(homeRepository);
    }

    @Bean
    public DeleteHomeCase deleteHomeCase(DeleteHomeOutputPort deleteHomeOutputPort, HomeRepository homeRepository) {
        return new DeleteHomeService(deleteHomeOutputPort, homeRepository);
    }

    @Bean
    public DeleteHomeOutputPort deleteHomeOutputPort(HomeRepository homeRepository) {
        return new HomePersistenceAdapter(homeRepository);
    }
}
