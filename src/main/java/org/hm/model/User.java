package org.hm.dto;

public record UserDto(
        Long id,
        String userName,
        String role,
        Boolean enabled
) {
}