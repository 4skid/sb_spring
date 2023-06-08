package com.example.MyBookShopApp.data.user;

import com.example.MyBookShopApp.data.book.file.FileDownloadEntity;
import com.example.MyBookShopApp.data.book.links.Book2UserEntity;
import com.example.MyBookShopApp.data.book.review.BookReviewEntity;
import com.example.MyBookShopApp.data.book.review.BookReviewLikeEntity;
import com.example.MyBookShopApp.data.book.review.MessageEntity;
import com.example.MyBookShopApp.data.payments.BalanceTransactionEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String hash;

    @Column(columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime regTime;

    @Column(columnDefinition = "INT NOT NULL")
    private int balance;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @OneToMany(mappedBy = "userId")
    private List<Book2UserEntity> book2User = new ArrayList<>();

    @OneToMany(mappedBy = "userId")
    private List<FileDownloadEntity> fileDownload = new ArrayList<>();

    @OneToMany(mappedBy = "userId")
    private List<BalanceTransactionEntity> balanceTransaction = new ArrayList<>();

    @OneToMany(mappedBy = "userId")
    private List<BookReviewEntity> bookReview = new ArrayList<>();

    @OneToMany(mappedBy = "userId")
    private List<BookReviewLikeEntity> bookReviewLike = new ArrayList<>();

    @OneToMany(mappedBy = "userId")
    private List<MessageEntity> messageList = new ArrayList<>();

    @OneToOne(mappedBy = "userId")
    private UserContactEntity userContactEntity;
}
