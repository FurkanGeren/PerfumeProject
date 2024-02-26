package com.perfumeProject.PerfumeProject.Model;
import jakarta.persistence.*;

import lombok.*;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_surname")
    private String userSurname;
    @Column(name = "user_email", unique = true)
    private String userEmail;
    @Column(name = "password")
    private String userPassword;
}
