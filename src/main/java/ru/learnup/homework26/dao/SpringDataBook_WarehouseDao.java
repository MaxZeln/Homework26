package ru.learnup.homework26.dao;

import org.springframework.stereotype.Component;
import ru.learnup.homework26.entity.Book_Warehouse;

import ru.learnup.homework26.repository.Book_WarehouseRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpringDataBook_WarehouseDao {

    private final Book_WarehouseRepository repository;

    public SpringDataBook_WarehouseDao (Book_WarehouseRepository repository) {
        this.repository = repository;
    }

    public Book_Warehouse findById(int id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Book_Warehouse> findAll() {
        List<Book_Warehouse> authorsRes = new ArrayList<>();
        Iterable<Book_Warehouse> authors = repository.findAll();
        authors.forEach(authorsRes::add);
        return authorsRes;
    }

    public void save(Book_Warehouse book_warehouse ) {
        repository.save(book_warehouse);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
