package br.com.msp.findurbuddy.adapter.input.dtos.requests.home;

import jakarta.validation.constraints.Pattern;

public record UpdateHomeRequest(
        String name,
        String description,
        String address,
        String city,
        String state,
        @Pattern(regexp = "([1-9]{2})(\\d{4,5})(\\d{4})", message = "Enter a valid phone number")
        String phone
) {
}
