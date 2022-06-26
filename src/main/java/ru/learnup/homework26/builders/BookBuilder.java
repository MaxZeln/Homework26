package ru.learnup.homework26.builders;

import ru.learnup.homework26.entity.Author;
import ru.learnup.homework26.entity.Book;

public class BookBuilder {

    private int id;
    private String title;
    private String publishing_year;
    private int pages;
    private int price;
    private Author author;

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public BookBuilder withPublishingYear(String publishing_year) {
        this.publishing_year = publishing_year;
        return this;
    }

    public BookBuilder withPages(int pages) {
        this.pages = pages;
        return this;
    }

    public BookBuilder withPrice(int price) {
        this.price = price;
        return this;
    }


    public Book build() {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishing_year(publishing_year);
        book.setPages(pages);
        book.setPrice(price);
        return book;
    }
}