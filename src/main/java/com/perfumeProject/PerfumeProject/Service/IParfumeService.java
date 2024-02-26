package com.perfumeProject.PerfumeProject.Service;

import com.perfumeProject.PerfumeProject.Model.Perfume;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface IParfumeService {
    List<Perfume> getPerfumes();

    Optional<Perfume> getPerfumeById(Long id);
}
