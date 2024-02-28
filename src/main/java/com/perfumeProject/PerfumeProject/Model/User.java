package com.perfumeProject.PerfumeProject.Model;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.*;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_surname")
    private String userSurname;
    @Column(name = "user_email", unique = true)
    private String email;
    @Column(name = "password")
    private String userPassword;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Favorite> perfume = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;



}
