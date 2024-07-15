package com.foro.hub.foroHub.domain.user;

public record DataResponseUser(
        Long id,
        String name
) {
    public DataResponseUser(User user) {
        this(user.getId(), user.getName());
    }
}
