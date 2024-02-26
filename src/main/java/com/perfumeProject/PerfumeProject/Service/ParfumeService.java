package com.perfumeProject.PerfumeProject.Service;


import com.perfumeProject.PerfumeProject.Model.Perfume;
import com.perfumeProject.PerfumeProject.Repository.PerfumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParfumeService implements IParfumeService {


    private final PerfumeRepository perfumeRepository;


    @Override
    public List<Perfume> getPerfumes(){
        return perfumeRepository.findAll();
    }

    @Override
    public Optional<Perfume> getPerfumeById(Long id){
        return perfumeRepository.findById(id);
    }
}
