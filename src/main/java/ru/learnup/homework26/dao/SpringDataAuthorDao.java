package ru.learnup.homework26.dao;

import org.springframework.stereotype.Component;
import ru.learnup.homework26.entity.Author;
import ru.learnup.homework26.repository.AuthorRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpringDataAuthorDao {

    private final AuthorRepository repository;

    public SpringDataAuthorDao(AuthorRepository repository) {
        this.repository = repository;
    }


    public Author findById(int id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Author> findAll() {
        List<Author> authorsRes = new ArrayList<>();
        Iterable<Author> authors = repository.findAll();
        authors.forEach(authorsRes::add);
        return authorsRes;
    }

    public void save(Author author) {
        repository.save(author);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

