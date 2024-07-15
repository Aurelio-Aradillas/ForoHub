package com.foro.hub.foroHub.domain.topic;

import com.foro.hub.foroHub.domain.course.DataResponseCourse;
import com.foro.hub.foroHub.domain.user.DataResponseUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataUpdatedTopic(
        @NotBlank
        String title,
        @NotBlank
        String message,
        LocalDateTime date_creation,
        Boolean status,
        @NotNull
        DataResponseUser user,
        @NotNull
        DataResponseCourse course
) {
}
