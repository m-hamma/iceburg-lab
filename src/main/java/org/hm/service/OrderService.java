package org.hm.service;

import org.hm.model.Order;
import org.hm.repository.OrderIcebergRepository;

public class OrderService {

    private final OrderIcebergRepository repository;

    public OrderService(OrderIcebergRepository repository) {
        this.repository = repository;
    }

    public void displaySchema() {

        System.out.println(
                repository.buildSchema()
        );

    }

    public void createOrder(Order order) {
        repository.insert(order);
    }

    public void displayOrders() {

        repository.findAll()
                .forEach(System.out::println);

    }
    public void updateStatus(
            Long orderId,
            String newStatus
    ) {

        repository.updateStatus(
                orderId,
                newStatus
        );

    }
}