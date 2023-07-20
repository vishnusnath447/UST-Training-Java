package com.ust.customerService.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record LoginDto(
        @NotNull(message = "Email cannot be null")
        @NotEmpty(message = "Email cannot be empty")
        @Email(message = "Provide a valid email")
        String email,
        @NotNull(message = "Password cannot be null")
        @NotEmpty(message = "Password cannot be empty")
        String password) {
}