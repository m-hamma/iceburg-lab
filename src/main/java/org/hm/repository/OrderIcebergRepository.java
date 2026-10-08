package org.hm.repository;

import org.apache.iceberg.Schema;
import org.apache.iceberg.types.Types;
import org.hm.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderIcebergRepository {

    private final List<Order> orders =
            new ArrayList<>();

    public Schema buildSchema() {

        return new Schema(
                Types.NestedField.required(1, "id", Types.LongType.get()),
                Types.NestedField.required(2, "customer", Types.StringType.get()),
                Types.NestedField.required(3, "amount", Types.DoubleType.get()),
                Types.NestedField.required(4, "status", Types.StringType.get())
        );
    }

    public void insert(Order order) {

        orders.add(order);

        System.out.println(
                "Insert order : " + order
        );
    }

    public List<Order> findAll() {
        return orders;
    }

    public void updateStatus(Long orderId, String newStatus) {

        for (int i = 0; i < orders.size(); i++) {

            Order currentOrder = orders.get(i);

            if (currentOrder.id().equals(orderId)) {

                orders.set(
                        i,
                        new Order(
                                currentOrder.id(),
                                currentOrder.customer(),
                                currentOrder.amount(),
                                newStatus
                        )
                );

                break;
            }
        }
    }
}