package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.model.entity.Question;
import com.epam.codemastery.InterviewX.service.QuestionService;
import com.epam.codemastery.InterviewX.service.VectorStoreService;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Component
public class QdrantVectorStoreImpl implements VectorStoreService {

    private final VectorStore vectorStore;

    private final QuestionService questionService;

    public QdrantVectorStoreImpl(VectorStore vectorStore, QuestionService questionService) {
        this.vectorStore = vectorStore;
        this.questionService = questionService;
    }

    public void addVectors() {
        List<Document> documents = new ArrayList<>();
        List<Question> questionsForSync = questionService.findQuestionsForSync();

        if (Objects.nonNull(questionsForSync)) {
            for (Question question : questionsForSync) {
                HashMap<String, Object> metaDataMap = new HashMap<>();
                metaDataMap.put("clientId", question.getClientId().toString());
                metaDataMap.put("projectId", question.getProjectId().toString());
                metaDataMap.put("languageId", question.getTechnologyId().toString());
                documents.add(new Document("java: ".concat(question.getQuestion()), metaDataMap));
            }
        }
        vectorStore.add(documents);
    }

    @Override
    public List<Document> searchDocument(String query) {
        return vectorStore.similaritySearch(SearchRequest.query(query));
    }
}