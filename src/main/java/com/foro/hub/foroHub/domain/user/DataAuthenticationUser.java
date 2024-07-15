package com.foro.hub.foroHub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record DataAuthenticationUser(
        @NotBlank
        String email,
        @NotBlank
        String password
) { }
