package com.foro.hub.foroHub.domain.course;

import com.foro.hub.foroHub.domain.topic.Topic;

import java.util.List;

public record DataResponseCourse(
        Long id,
        String name,
        String category
) {

public DataResponseCourse(Course course) {
    this(course.getId(), course.getName(), course.getCategory());
}


}
