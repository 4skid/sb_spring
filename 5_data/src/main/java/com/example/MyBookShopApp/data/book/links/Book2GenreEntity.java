package com.example.MyBookShopApp.data.book.links;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.genre.GenreEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book2genre")
@Getter
@Setter
public class Book2GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book bookId;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private GenreEntity genreId;
}
