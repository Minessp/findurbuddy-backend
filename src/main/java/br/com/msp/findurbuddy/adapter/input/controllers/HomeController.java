package br.com.msp.findurbuddy.adapter.input.controllers;

import br.com.msp.findurbuddy.adapter.input.dtos.requests.home.RegisterHomeRequest;
import br.com.msp.findurbuddy.core.usecases.port.in.RegisterHomeCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final RegisterHomeCase registerHomeCase;

    public HomeController(RegisterHomeCase registerHomeCase) {
        this.registerHomeCase = registerHomeCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterHomeRequest request) {
        registerHomeCase.execute(request);
    }
}
