package com.perfumeProject.PerfumeProject.Service;

import com.perfumeProject.PerfumeProject.Model.Content;
import com.perfumeProject.PerfumeProject.Repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentService implements IContentService{

    private final ContentRepository contentRepository;

    @Override
    public List<Content> getContents(){
        return contentRepository.findAll();
    }

    @Override
    public Optional<Content> getContentsById(Long id){return contentRepository.findById(id);}


}
