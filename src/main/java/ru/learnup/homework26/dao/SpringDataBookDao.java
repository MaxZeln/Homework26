package ru.learnup.homework26.dao;

import org.springframework.stereotype.Component;
import ru.learnup.homework26.entity.Book;

import ru.learnup.homework26.repository.BookRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpringDataBookDao {

    private final BookRepository repository;

    public SpringDataBookDao(BookRepository repository) {
        this.repository = repository;
    }

    public Book findById(int id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Book> findAll() {
        List<Book> booksRes = new ArrayList<>();
        Iterable<Book> books = repository.findAll();
        books.forEach(booksRes::add);
        return booksRes;
    }

    public void save(Book book) {
        repository.save(book);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
