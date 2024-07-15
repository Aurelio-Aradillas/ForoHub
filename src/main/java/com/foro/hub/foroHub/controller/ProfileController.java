package com.foro.hub.foroHub.controller;

import com.foro.hub.foroHub.domain.profile.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public ResponseEntity<Stream<DataResponseProfile>> toList() {
        return ResponseEntity.ok(profileRepository.findAll().stream().map(DataResponseProfile::new));
    }

    @PostMapping
    public ResponseEntity<DataResponseProfile> create(@RequestBody @Valid DataCreationProfile dataCreationProfile) {
        Profile profile = profileRepository.save(new Profile(dataCreationProfile));
        DataResponseProfile dataResponseProfile = new DataResponseProfile(profile);
        return ResponseEntity.ok(dataResponseProfile);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DataResponseProfile> update(@PathVariable Long id,@RequestBody @Valid DataUpdatedProfile dataUpdatedProfile) {
        Profile profile = profileRepository.getReferenceById(id);
        profile.update(dataUpdatedProfile);
        return ResponseEntity.ok(new DataResponseProfile(profile));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Profile profile = profileRepository.getReferenceById(id);
        profileRepository.delete(profile);
        return ResponseEntity.noContent().build();
    }

}
