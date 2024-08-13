package com.epam.codemastery.InterviewX.controller;


import com.epam.codemastery.InterviewX.service.impl.QdrantVectorStoreImpl;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vector")
public class VectorSearchController {

    @Autowired
    private QdrantVectorStoreImpl vectorStoreService;


    @GetMapping("/search")
    public List<Document> searchVector(@RequestParam(defaultValue = "Angular") String query) {
        List<Document> documents = vectorStoreService.searchDocument(query);
        return documents;
    }

    @GetMapping("/store")
    public void storeVector() {
        vectorStoreService.addVectors();
    }


}
