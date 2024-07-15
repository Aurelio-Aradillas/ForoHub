package com.foro.hub.foroHub.domain.answer;

import com.foro.hub.foroHub.domain.topic.Topic;
import com.foro.hub.foroHub.domain.user.User;

import java.time.LocalDateTime;

public record DataUpdatedAnswer(
        String message,
        Topic topic,
        LocalDateTime date_creation,
        User user,
        String solution
) {
}
