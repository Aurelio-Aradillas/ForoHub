package com.foro.hub.foroHub.domain.answer;

import com.foro.hub.foroHub.domain.topic.DataResponseTopic;
import com.foro.hub.foroHub.domain.user.DataResponseUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataCreacionAnswer(
        @NotBlank
        String message,
        @NotNull
        DataResponseTopic topic,
        @NotBlank
        LocalDateTime date_creation,
        @NotNull
        DataResponseUser user,
        @NotBlank
        String solution
) {
}
