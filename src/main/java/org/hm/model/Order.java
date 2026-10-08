package org.hm.model;

public record Order(
        Long id,
        String customer,
        Double amount,
        String status
) {
}