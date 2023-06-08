package com.example.MyBookShopApp.data.book.file;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "file_download")
@Getter
@Setter
public class FileDownloadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book bookId;

    @Column(columnDefinition = "INT NOT NULL DEFAULT 1")
    private int count;

}
