package com.epam.codemastery.InterviewX.service;

import org.springframework.ai.document.Document;

import java.util.List;

public interface VectorStoreService {

    void addVectors();

    List<Document> searchDocument(String query);


}
