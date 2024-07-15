package com.foro.hub.foroHub.domain.course;

import jakarta.validation.constraints.NotBlank;

public record DataUpdatedCourse(
        @NotBlank
        String name,
        @NotBlank
        String category
) {
}
