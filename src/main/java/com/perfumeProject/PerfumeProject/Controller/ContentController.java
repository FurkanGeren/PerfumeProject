package com.perfumeProject.PerfumeProject.Controller;

import com.perfumeProject.PerfumeProject.Model.Content;
import com.perfumeProject.PerfumeProject.Model.Perfume;
import com.perfumeProject.PerfumeProject.Service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/all")
    public ResponseEntity<List<Content>> getContents(){
        if(!contentService.getContents().isEmpty()){
            return new ResponseEntity<>(contentService.getContents(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Content> getContentById(@PathVariable Long id){
        Optional<Content> content = contentService.getContentsById(id);
        return content.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
