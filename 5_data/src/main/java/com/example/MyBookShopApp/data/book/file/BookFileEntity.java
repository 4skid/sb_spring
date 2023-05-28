package com.example.MyBookShopApp.data.book.file;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book_file")
@Getter
@Setter
public class BookFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String hash;

    @OneToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private BookFileTypeEntity bookFileTypeEntity;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String path;


}
