package com.example.MyBookShopApp.data.book.file;

import com.example.MyBookShopApp.data.enums.FileType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book_file_type")
@Getter
@Setter
public class BookFileTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255)" , nullable = false)
    private FileType fileType;

    @Column(columnDefinition = "TEXT")
    private String description;

}
