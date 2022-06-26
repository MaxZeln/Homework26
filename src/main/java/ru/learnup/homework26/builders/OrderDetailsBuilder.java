package ru.learnup.homework26.builders;

import ru.learnup.homework26.entity.Book;
import ru.learnup.homework26.entity.Order;
import ru.learnup.homework26.entity.Order_Details;

public class OrderDetailsBuilder {

    private int id;
    private Book book;
    private Order order;
    private int amount;
    private int price;

    public OrderDetailsBuilder withBookId(Book book) {
        this.book = book;
        return this;
    }
    public OrderDetailsBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }

    public OrderDetailsBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public OrderDetailsBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Order_Details build() {
        Order_Details order_details = new Order_Details();
        order_details.setOrder(order);
        order_details.setAmount(amount);
        order_details.setPrice(price);
        order_details.setBook(book);
        return order_details;
    }
}
