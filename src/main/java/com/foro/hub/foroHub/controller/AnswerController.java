package com.foro.hub.foroHub.controller;

import com.foro.hub.foroHub.domain.answer.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping
    public ResponseEntity<Stream<DataResponseAnswer>> toList() {
        return ResponseEntity.ok(answerRepository.findAll().stream().map(DataResponseAnswer::new));
    }

    @PostMapping
    public ResponseEntity<DataResponseAnswer> create(@RequestBody @Valid DataCreacionAnswer dataCreacionAnswer) {
        Answer answer = answerRepository.save(new Answer(dataCreacionAnswer));
        return ResponseEntity.ok(new DataResponseAnswer(answer));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DataResponseAnswer> update(@RequestBody @Valid DataUpdatedAnswer dataUpdatedAnswer, @PathVariable Long id) {
        Answer answer = answerRepository.getReferenceById(id);
        answer.update(dataUpdatedAnswer);
        return ResponseEntity.ok(new DataResponseAnswer(answer));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Answer answer = answerRepository.getReferenceById(id);
        answerRepository.delete(answer);
        return ResponseEntity.noContent().build();
    }

}
