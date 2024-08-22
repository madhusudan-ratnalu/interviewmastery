package com.epam.codemastery.InterviewX.controller;


import com.epam.codemastery.InterviewX.service.impl.QdrantVectorStoreImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vector")
public class VectorSearchController {

    private final QdrantVectorStoreImpl vectorStoreService;

    public VectorSearchController(QdrantVectorStoreImpl qdrantVectorStore) {
        this.vectorStoreService = qdrantVectorStore;
    }

    //    TODO:
    //    1. Make it as scheduler
    @GetMapping("/sync")
    public String findQuestionsForSync() {
        vectorStoreService.addVectors();
        return "Vector Stored is refreshed";
    }

}
