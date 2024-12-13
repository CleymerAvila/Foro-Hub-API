package com.alura.ForoHubAPI.dto.user;

import jakarta.validation.constraints.NotBlank;

public record RegisterUserDTO(@NotBlank String name, @NotBlank String password, @NotBlank String nameProfile) {
    
}
