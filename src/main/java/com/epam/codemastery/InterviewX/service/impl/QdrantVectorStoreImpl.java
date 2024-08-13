package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.service.VectorStoreService;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class QdrantVectorStoreImpl implements VectorStoreService {

    @Autowired
    VectorStore vectorStore;

    @Value("classpath:/docs/raw_data.csv")
    private Resource rawData;

    public void addVectors() {
        String line = "";
        String csvSplitBy = ",";
        List<Document> documents = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rawData.getFile()))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                documents.add(new Document(values[1], Map.of("lang", values[0])));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        vectorStore.add(documents);
    }

    @Override
    public List<Document> searchDocument(String query) {
        return vectorStore.similaritySearch(SearchRequest.query(query));
    }
}