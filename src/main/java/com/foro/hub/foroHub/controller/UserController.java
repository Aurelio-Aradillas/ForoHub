package com.foro.hub.foroHub.controller;

import com.foro.hub.foroHub.domain.user.DataResponseUser;
import com.foro.hub.foroHub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Stream<DataResponseUser>> toList() {
        return ResponseEntity.ok(userRepository.findAll().stream().map(DataResponseUser::new));
    }

}

