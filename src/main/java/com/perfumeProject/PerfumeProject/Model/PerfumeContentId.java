package com.perfumeProject.PerfumeProject.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class PerfumeContentId implements Serializable {

    @Column(name = "perfume_id")
    private Long perfumeId;

    @Column(name = "content_id")
    private Long contentId;

}
