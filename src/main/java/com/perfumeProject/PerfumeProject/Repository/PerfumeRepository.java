package com.perfumeProject.PerfumeProject.Repository;

import com.perfumeProject.PerfumeProject.Model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PerfumeRepository extends JpaRepository<Perfume,Long> {


}
