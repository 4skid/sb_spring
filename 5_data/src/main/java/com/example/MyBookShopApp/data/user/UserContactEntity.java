package com.example.MyBookShopApp.data.user;


import com.example.MyBookShopApp.data.enums.ContactType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_contact")
@Getter
@Setter
public class UserContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userId;

    @Column(nullable = false)
    private ContactType type;

    @Column(columnDefinition = "SMALLINT NOT NULL")
    private short approved;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String code;

    @Column(columnDefinition = "INT")
    private int codeTrails;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime codeTime;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String contact;
}
