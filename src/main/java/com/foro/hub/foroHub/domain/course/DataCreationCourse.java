package com.foro.hub.foroHub.domain.course;

import jakarta.validation.constraints.NotBlank;

public record DataCreationCourse(
        @NotBlank
        String name,
        @NotBlank
        String category
) {
}
