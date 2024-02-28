package com.perfumeProject.PerfumeProject.Service;

import com.perfumeProject.PerfumeProject.Model.Content;

import java.util.List;
import java.util.Optional;

public interface IContentService {

    public List<Content> getContents();

    Optional<Content> getContentsById(Long id);
}