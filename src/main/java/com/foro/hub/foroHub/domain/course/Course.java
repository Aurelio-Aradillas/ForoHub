package com.foro.hub.foroHub.domain.course;

import com.foro.hub.foroHub.domain.topic.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "courses")
@Entity(name = "Course")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Topic> topics;

    public Course(DataCreationCourse dataCreationCourse){
        this.name = dataCreationCourse.name();
        this.category = dataCreationCourse.category();
    }

    public Course(Long id, String name, String category) {
        this.id=id;
        this.name = name;
        this.category = category;
    }

    public void update(DataUpdatedCourse dataUpdatedCourse) {
        this.name = dataUpdatedCourse.name();
        this.category = dataUpdatedCourse.category();
    }
}
