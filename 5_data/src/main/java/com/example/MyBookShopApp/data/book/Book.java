package com.example.MyBookShopApp.data.book;

import com.example.MyBookShopApp.data.book.review.BookReviewEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pub_date", columnDefinition = "DATE NOT NULL")
    private Date pubDate;

    @Column(name = "is_bestseller", columnDefinition = "SMALLINT NOT NULL")
    private Integer isBestseller;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String slug;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String title;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "INT NOT NULL")
    private Integer price;

    @Column(columnDefinition = "DOUBLE PRECISION DEFAULT 0")
    private double discount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book2Author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    public List<Author> authors = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_review",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<BookReviewEntity> bookReviews = new ArrayList<>();

    public String getAuthorName() {
        String name = "";
        for (Author author : authors) {
            name = author.getName();
        }
        return name;
    }

    public Integer newPrice() {
        return Math.toIntExact(Math.round(price * discount));
    }
}
