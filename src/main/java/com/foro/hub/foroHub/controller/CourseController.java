package com.foro.hub.foroHub.controller;

import com.foro.hub.foroHub.domain.course.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity<Stream<DataResponseCourse>> toList() {
        return ResponseEntity.ok(courseRepository.findAll().stream().map(DataResponseCourse::new));
    }

    @PostMapping
    public ResponseEntity<DataResponseCourse> create(@RequestBody @Valid DataCreationCourse dataCreationCourse) {
        Course course =  courseRepository.save(new Course(dataCreationCourse));
        DataResponseCourse dataResponseCourse = new DataResponseCourse(course);
        return ResponseEntity.ok(dataResponseCourse);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DataResponseCourse> update(@PathVariable Long id,@RequestBody @Valid DataUpdatedCourse dataUpdatedCourse) {
        Course course = courseRepository.getReferenceById(id);
        course.update(dataUpdatedCourse);
        return ResponseEntity.ok(new DataResponseCourse(course));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Course course = courseRepository.getReferenceById(id);
        courseRepository.delete(course);
        return ResponseEntity.noContent().build();
    }

}
