package ru.learnup.homework26.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.homework26.entity.Book_Warehouse;

@Repository
public interface Book_WarehouseRepository extends CrudRepository <Book_Warehouse, Integer> {
}
