package com.foro.hub.foroHub.domain.answer;

import com.foro.hub.foroHub.domain.course.Course;
import com.foro.hub.foroHub.domain.topic.Topic;
import com.foro.hub.foroHub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "answers")
@Entity(name = "Answer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    private LocalDateTime date_creation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String solution;

    public Answer(DataCreacionAnswer dataCreacionAnswer) {
        this.message=dataCreacionAnswer.message();
        this.date_creation = LocalDateTime.now();
        this.user = new User(dataCreacionAnswer.user().id(),dataCreacionAnswer.user().name());
        this.solution = dataCreacionAnswer.solution();
        this.topic = new Topic(
                dataCreacionAnswer.topic().id(),
                dataCreacionAnswer.topic().title(),
                dataCreacionAnswer.topic().message(),
                dataCreacionAnswer.topic().date_creation(),
                dataCreacionAnswer.topic().status(),
                new User(dataCreacionAnswer.topic().user().id(),
                        dataCreacionAnswer.topic().user().name()),
                new Course(dataCreacionAnswer.topic().course().id(),
                        dataCreacionAnswer.topic().course().name(),
                        dataCreacionAnswer.topic().course().category())
        );

    }

    public void update(DataUpdatedAnswer dataUpdatedAnswer) {
        this.message=dataUpdatedAnswer.message();
        this.date_creation = LocalDateTime.now();
        this.user = new User(dataUpdatedAnswer.user().getId(),dataUpdatedAnswer.user().getName());
        this.solution = dataUpdatedAnswer.solution();
        this.topic = new Topic(
                dataUpdatedAnswer.topic().getId(),
                dataUpdatedAnswer.topic().getTitle(),
                dataUpdatedAnswer.topic().getMessage(),
                dataUpdatedAnswer.topic().getDate_creation(),
                dataUpdatedAnswer.topic().getStatus(),
                new User(dataUpdatedAnswer.topic().getUser().getId(),
                        dataUpdatedAnswer.topic().getUser().getName()),
                new Course(dataUpdatedAnswer.topic().getCourse().getId(),
                        dataUpdatedAnswer.topic().getCourse().getName(),
                        dataUpdatedAnswer.topic().getCourse().getCategory())
        );
    }
}
