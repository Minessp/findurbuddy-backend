package br.com.msp.findurbuddy.adapter.input.controllers;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.UpdateHomeRequest;
import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.RegisterHomeRequest;
import br.com.msp.findurbuddy.adapter.input.mappers.HomeMapper;
import br.com.msp.findurbuddy.core.usecases.port.in.DeleteHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.in.RegisterHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.in.UpdateHomeCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homes")
public class HomeController {
    private final RegisterHomeCase registerHomeCase;
    private final DeleteHomeCase deleteHomeCase;
    private final UpdateHomeCase updateHomeCase;
    private final HomeMapper homeMapper;

    public HomeController(RegisterHomeCase registerHomeCase, DeleteHomeCase deleteHomeCase,
                          UpdateHomeCase updateHomeCase, HomeMapper homeMapper) {
        this.registerHomeCase = registerHomeCase;
        this.deleteHomeCase = deleteHomeCase;
        this.updateHomeCase = updateHomeCase;
        this.homeMapper = homeMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerHome(@RequestBody @Valid RegisterHomeRequest request) {
        registerHomeCase.execute(homeMapper.registerHomeRequestToDomain(request));
    }

    @DeleteMapping("/{home-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteHome(@PathVariable("home-id") String homeId) {
        deleteHomeCase.execute(homeId);
    }

    @PatchMapping("/{home-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateHome(@PathVariable("home-id") String homeId, @RequestBody @Valid UpdateHomeRequest request) {
        updateHomeCase.execute(homeId, request);
    }
}
