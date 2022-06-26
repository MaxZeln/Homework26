package ru.learnup.homework26.dao;

import org.springframework.stereotype.Component;
import ru.learnup.homework26.entity.Order;
import ru.learnup.homework26.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpringDataOrderDao {
    private final OrderRepository repository;

    public SpringDataOrderDao(OrderRepository repository) {
        this.repository = repository;
    }

    public Order findById(int id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Order> findAll() {
        List<Order> ordersRes = new ArrayList<>();
        Iterable<Order> orders = repository.findAll();
        orders.forEach(ordersRes::add);
        return ordersRes;
    }

    public void save(Order order) {
        repository.save(order);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}