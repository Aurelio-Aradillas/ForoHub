package com.foro.hub.foroHub.domain.answer;

import com.foro.hub.foroHub.domain.course.DataResponseCourse;
import com.foro.hub.foroHub.domain.topic.DataResponseTopic;
import com.foro.hub.foroHub.domain.user.DataResponseUser;

import java.time.LocalDateTime;

public record DataResponseAnswer(
        Long id,
        String message,
        DataResponseTopic topic,
        LocalDateTime date_creation,
        DataResponseUser user,
        String solution
) {
    public DataResponseAnswer(Answer answer) {
        this(
                answer.getId(),
                answer.getMessage(),
                new DataResponseTopic(
                        answer.getTopic().getId(),
                        answer.getTopic().getTitle(),
                        answer.getTopic().getMessage(),
                        answer.getTopic().getDate_creation(),
                        answer.getTopic().getStatus(),
                        new DataResponseUser(answer.getTopic().getUser().getId(),answer.getTopic().getUser().getName()),
                        new DataResponseCourse(answer.getTopic().getCourse().getId(),answer.getTopic().getCourse().getName(),answer.getTopic().getCourse().getCategory())
                ),
                answer.getDate_creation(),
                new DataResponseUser(
                        answer.getUser().getId(),
                        answer.getUser().getName()
                ),
                answer.getSolution()
        );
    }

}
