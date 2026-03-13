package br.com.msp.findurbuddy.adapter.input.controllers;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.RegisterHomeRequest;
import br.com.msp.findurbuddy.core.usecases.port.in.DeleteHomeCase;
import br.com.msp.findurbuddy.core.usecases.port.in.RegisterHomeCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homes")
public class HomeController {
    private final RegisterHomeCase registerHomeCase;
    private final DeleteHomeCase deleteHomeCase;

    public HomeController(RegisterHomeCase registerHomeCase, DeleteHomeCase deleteHomeCase) {
        this.registerHomeCase = registerHomeCase;
        this.deleteHomeCase = deleteHomeCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerHome(@RequestBody @Valid RegisterHomeRequest request) {
        registerHomeCase.execute(request);
    }

    @DeleteMapping("/{home-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteHome(@PathVariable("home-id") String homeId) {
        deleteHomeCase.execute(homeId);
    }
}
