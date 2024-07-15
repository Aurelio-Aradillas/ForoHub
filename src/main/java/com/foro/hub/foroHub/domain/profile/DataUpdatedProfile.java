package com.foro.hub.foroHub.domain.profile;

import jakarta.validation.constraints.NotBlank;

public record DataUpdatedProfile(
        @NotBlank
        String name
) {
}
