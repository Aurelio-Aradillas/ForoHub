package com.foro.hub.foroHub.controller;

import com.foro.hub.foroHub.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public ResponseEntity<Stream<DataResponseTopic>> toList() {
        return ResponseEntity.ok(topicRepository.findAll().stream().map(DataResponseTopic::new));
    }

    @PostMapping
    public ResponseEntity<DataResponseTopic> create(@RequestBody @Valid DataCreationTopic dataCreationTopic) {
        Topic topic = topicRepository.save(new Topic(dataCreationTopic));
        return ResponseEntity.ok(new DataResponseTopic(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DataResponseTopic> update(@PathVariable Long id, @RequestBody @Valid DataUpdatedTopic dataUpdatedTopic){
        Topic topic = topicRepository.getReferenceById(id);
        topic.update(dataUpdatedTopic);
        return ResponseEntity.ok(new DataResponseTopic(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        topicRepository.delete(topic);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseTopic> getById(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataResponseTopic(topic));
    }

}
