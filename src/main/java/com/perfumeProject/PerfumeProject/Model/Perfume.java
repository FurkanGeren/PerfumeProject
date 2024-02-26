package com.perfumeProject.PerfumeProject.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Perfume")
@Table(name = "perfume")
@Data
public class Perfume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long perfumeId;

    @Column(name = "parfume_name")
    private String perfumeName;

    @OneToMany(
            mappedBy = "perfume",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PerfumeContent> contents = new ArrayList<>();


}
