package com.foro.hub.foroHub.domain.profile;

public record DataResponseProfile(
        Long id,
        String name
) {
    public DataResponseProfile(Profile profile) {
        this(profile.getId(), profile.getName());
    }
}
