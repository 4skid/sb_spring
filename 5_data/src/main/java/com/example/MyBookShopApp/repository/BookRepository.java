package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("FROM Book")
    List<Book> findAllBooksById();
}
