package com.perfumeProject.PerfumeProject.Repository;

import com.perfumeProject.PerfumeProject.Model.Content;
import com.perfumeProject.PerfumeProject.Model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

}
