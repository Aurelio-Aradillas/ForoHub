package com.foro.hub.foroHub.domain.topic;

import com.foro.hub.foroHub.domain.course.DataResponseCourse;
import com.foro.hub.foroHub.domain.user.DataResponseUser;

import java.time.LocalDateTime;

public record DataResponseTopic(
        Long id,
        String title,
        String message,
        LocalDateTime date_creation,
        Boolean status,
        DataResponseUser user,
        DataResponseCourse course
) {
    public DataResponseTopic(Topic topic){
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getDate_creation(),
                topic.getStatus(),
                new DataResponseUser(topic.getUser().getId(),topic.getUser().getName()),
                new DataResponseCourse(topic.getCourse().getId(),topic.getCourse().getName(),topic.getCourse().getCategory())
        );
    }


}
