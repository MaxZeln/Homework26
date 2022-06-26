package ru.learnup.homework26.builders;

import ru.learnup.homework26.entity.Book;
import ru.learnup.homework26.entity.Book_Warehouse;

public class BookWarehouseBuilder {

    private int id;
    private int books_amount;
    private Book book;

    public BookWarehouseBuilder withBookAmount(int books_amount) {
        this.books_amount = books_amount;
        return this;
    }

    public BookWarehouseBuilder withBook(Book book) {
        this.book = book;
        return this;
    }

    public Book_Warehouse build() {
        Book_Warehouse book_warehouse = new Book_Warehouse();
        book_warehouse.setBooks_amount(books_amount);
        book_warehouse.setBook(book);
        return book_warehouse;
    }
}
