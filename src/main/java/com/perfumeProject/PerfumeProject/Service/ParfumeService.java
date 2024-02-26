package com.perfumeProject.PerfumeProject.Service;


import com.perfumeProject.PerfumeProject.Model.Perfume;
import com.perfumeProject.PerfumeProject.Repository.PerfumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParfumeService implements IParfumeService {


    private final PerfumeRepository perfumeRepository;


    @Override
    public List<Perfume> getPerfumes(){
        return perfumeRepository.findAll();
    }
}
