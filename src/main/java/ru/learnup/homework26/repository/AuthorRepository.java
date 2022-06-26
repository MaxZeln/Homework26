package ru.learnup.homework26.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.homework26.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
