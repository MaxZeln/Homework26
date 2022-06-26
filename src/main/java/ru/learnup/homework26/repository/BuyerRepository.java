package ru.learnup.homework26.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.homework26.entity.Buyer;

@Repository
public interface BuyerRepository extends CrudRepository <Buyer, Integer> {
}
