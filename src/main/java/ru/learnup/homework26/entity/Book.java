package ru.learnup.homework26.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String publishing_year;

    @Column(nullable = false)
    private int pages;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Order_Details> order_details;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishing_year='" + publishing_year + '\'' +
                ", number_of_pages=" + pages +
                ", price=" + price +
                ", author_id=" + author.getId() +
                '}';
    }
}