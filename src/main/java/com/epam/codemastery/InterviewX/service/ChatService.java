package com.epam.codemastery.InterviewX.service;

import com.epam.codemastery.InterviewX.model.QuestionSearchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatService {
    private static final Logger log = LoggerFactory.getLogger(ChatService.class);
    private final VectorStore vectorStore;

    private final ChatClient chatClient;

    @Value("classpath:/prompts/interview.st")
    private Resource interviewPrompt;

    public ChatService(VectorStore vectorStore, ChatClient.Builder chatClientBuilder) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClientBuilder.build();
    }


    public AssistantMessage generateRoadMap(QuestionSearchRequest questionSearchRequest, String message) {
        Prompt prompt = new Prompt(List.of(getSystemMessage(questionSearchRequest), new UserMessage(message)));
        ChatResponse chatResponse = chatClient.prompt(prompt).call().chatResponse();
        log.info("AI responded.");
        return chatResponse.getResult().getOutput();
    }

    public Message getSystemMessage(QuestionSearchRequest questionSearchRequest) {
        String documents = this.search("java", 10, questionSearchRequest)
                .stream().map(Document::getContent)
                .collect(Collectors.joining("\n"));
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(interviewPrompt);
        return systemPromptTemplate.createMessage(Map.of("documents", documents));
    }

    public List<Document> search(String query, int k, QuestionSearchRequest questionSearchRequest) {
        SearchRequest searchRequest = SearchRequest.query(query)
                .withTopK(k);
//        FIXME: Add filter capability at later stage
//                .withFilterExpression("clientId == '" + questionSearchRequest.getClientId() + "' AND technologyId =='" +
//                        questionSearchRequest.getLanguageId() + "' AND projectId == '" + questionSearchRequest.getProjectId() + "'");

        return vectorStore.similaritySearch(searchRequest);
    }


}
