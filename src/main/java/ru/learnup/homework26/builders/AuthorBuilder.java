package ru.learnup.homework26.builders;

import ru.learnup.homework26.entity.Author;
import ru.learnup.homework26.entity.Book;

import java.util.List;

public class AuthorBuilder {

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private List<Book> books;


    public AuthorBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AuthorBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public AuthorBuilder withPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public AuthorBuilder withBooks(List<Book> books) {
        this.books = books;
        return this;
    }


    public Author build() {
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        author.setPatronymic(patronymic);
        return author;
    }
}
