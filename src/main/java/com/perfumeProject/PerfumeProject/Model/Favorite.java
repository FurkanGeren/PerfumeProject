package com.perfumeProject.PerfumeProject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity(name = "Favorite")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorite_")
public class Favorite{

    @EmbeddedId
    private FavoriteId id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("perfume_id")
    private Perfume perfume;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    private User user;

    @Override
    public int hashCode() {
        return Objects.hash(perfume, user);
    }
}
