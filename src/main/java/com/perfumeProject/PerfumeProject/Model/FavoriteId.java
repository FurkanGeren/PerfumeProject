package com.perfumeProject.PerfumeProject.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class FavoriteId implements Serializable {

    @Column(name = "perfume_id")
    private Long perfume_id;

    @Column(name = "user_id")
    private Long user_id;

}
