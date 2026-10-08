package org.hm;

import org.hm.model.Order;
import org.hm.repository.OrderIcebergRepository;
import org.hm.service.OrderService;

public class Main {

    public static void main(String[] args) {

        OrderIcebergRepository orderRepository =
                new OrderIcebergRepository();

        OrderService orderService =
                new OrderService(orderRepository);

        orderService.displaySchema();

        orderService.createOrder(
                new Order(
                        1L,
                        "Mohamed",
                        100.0,
                        "CREATED"
                )
        );

        orderService.createOrder(
                new Order(
                        2L,
                        "Alice",
                        250.0,
                        "CREATED"
                )
        );

        orderService.createOrder(
                new Order(
                        3L,
                        "Bob",
                        80.0,
                        "CREATED"
                )
        );
        orderService.updateStatus(
                1L,
                "PAID"
        );

        orderService.updateStatus(
                3L,
                "CANCELLED"
        );
        System.out.println("\n==== ORDERS ====\n");

        orderService.displayOrders();
    }
}