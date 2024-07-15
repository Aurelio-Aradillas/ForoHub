package com.foro.hub.foroHub.domain.topic;


import com.foro.hub.foroHub.domain.answer.Answer;
import com.foro.hub.foroHub.domain.answer.DataCreacionAnswer;
import com.foro.hub.foroHub.domain.course.Course;
import com.foro.hub.foroHub.domain.user.DataResponseUser;
import com.foro.hub.foroHub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private LocalDateTime date_creation;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Answer> answers;

    public Topic(DataCreationTopic dataCreationTopic) {
        this.title = dataCreationTopic.title();
        this.message = dataCreationTopic.message();
        this.date_creation = LocalDateTime.now();
        this.status = Boolean.TRUE;
        this.user = new User(dataCreationTopic.user().id(),dataCreationTopic.user().name());
        this.course = new Course(dataCreationTopic.course().id(),dataCreationTopic.course().name(),dataCreationTopic.course().category());

    }

    public Topic(Long id, String title, String message, LocalDateTime dateCreation, Boolean status, User user, Course course) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.date_creation = dateCreation;
        this.status = status;
        this.user = new User(user.getId(),user.getName());;
        this.course = new Course(course.getId(),course.getName(),course.getCategory());
    }


    public void update(DataUpdatedTopic dataUpdatedTopic) {
        this.title = dataUpdatedTopic.title();
        this.message = dataUpdatedTopic.message();
        this.date_creation = LocalDateTime.now();
        this.status = dataUpdatedTopic.status();
        this.user = new User(dataUpdatedTopic.user().id(),dataUpdatedTopic.user().name());
        this.course = new Course(dataUpdatedTopic.course().id(),dataUpdatedTopic.course().name(),dataUpdatedTopic.course().category());
    }
}
