package ru.learnup.homework26.repository;

import org.springframework.data.repository.CrudRepository;
import ru.learnup.homework26.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
