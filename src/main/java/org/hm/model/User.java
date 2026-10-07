package org.hm.model;

public record User(
        Long id,
        String userName,
        String role,
        Boolean enabled
) {
}