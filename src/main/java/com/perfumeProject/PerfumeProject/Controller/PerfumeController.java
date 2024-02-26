package com.perfumeProject.PerfumeProject.Controller;

import com.perfumeProject.PerfumeProject.Model.Perfume;
import com.perfumeProject.PerfumeProject.Service.ParfumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/perfumes")
@RequiredArgsConstructor
public class PerfumeController {

    @Autowired
    ParfumeService parfumeService;

    @GetMapping("/all")
    public ResponseEntity<List<Perfume>> getPerfumes() {
        if (!parfumeService.getPerfumes().isEmpty()) {
            return new ResponseEntity<>(parfumeService.getPerfumes(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

}

    @GetMapping("/{id}")
    public ResponseEntity<Perfume> getPerfumeById(@PathVariable Long id){
        Optional<Perfume> perfume = parfumeService.getPerfumeById(id);
        return perfume.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
/*
    @GetMapping("/all")
    public String getPerfumes(Model model) {
        List<Perfume> allPerfumes = parfumeService.getPerfumes();
        if(allPerfumes.isEmpty()){
            model.addAttribute("message", "Maalesef parfum bulunamadi.");
        }else{
            model.addAttribute("perfumes", allPerfumes);
        }
        return "perfume-list";
    }
    }*/