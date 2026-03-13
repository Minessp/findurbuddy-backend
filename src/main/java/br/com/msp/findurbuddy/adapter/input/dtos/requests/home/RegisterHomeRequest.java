package br.com.msp.findurbuddy.adapter.input.dtos.requests.home;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterHomeRequest(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Description is required")
        String description,
        @NotBlank(message = "Address is required")
        String address,
        @NotBlank(message = "City is required")
        String city,
        @NotBlank(message = "State is required")
        String state,
        @NotBlank(message = "Phone is required")
        @Pattern(regexp = "([1-9]{2})(\\d{4,5})(\\d{4})", message = "Enter a valid phone number")
        String phone
) {
}
