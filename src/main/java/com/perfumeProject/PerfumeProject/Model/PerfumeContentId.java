package com.perfumeProject.PerfumeProject.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PerfumeContentId implements Serializable {

    @Column(name = "perfume_id")
    private Long perfumeId;

    @Column(name = "content_id")
    private Long contentId;

    // constructor, getter, setter

    @Override
    public int hashCode() {
        return Objects.hash(perfumeId, contentId);
    }

}
