package com.perfumeProject.PerfumeProject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "Content")
@Data
@Table(name = "content")

public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "content_img_url")
    private String contentUrl;

    @OneToMany(
            mappedBy = "content",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PerfumeContent> perfumes = new ArrayList<>();
}
