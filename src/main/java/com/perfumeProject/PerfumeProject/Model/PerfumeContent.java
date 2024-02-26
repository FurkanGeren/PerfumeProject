package com.perfumeProject.PerfumeProject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "PerfumeContent")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "perfume_content")
public class PerfumeContent{

  @EmbeddedId
  private PerfumeContentId id;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("perfumeId")
  private Perfume perfume;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("contentId")
  private Content content;



  @Override
  public int hashCode() {
    return Objects.hash(perfume, content);
  }
}
