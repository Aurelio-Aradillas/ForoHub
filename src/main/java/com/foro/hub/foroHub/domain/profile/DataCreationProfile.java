package com.foro.hub.foroHub.domain.profile;

import jakarta.validation.constraints.NotBlank;

public record DataCreationProfile(
        @NotBlank
        String name
) {
}
