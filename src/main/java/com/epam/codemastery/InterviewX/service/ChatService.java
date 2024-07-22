package com.epam.codemastery.InterviewX.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
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
    private VectorStore vectorStore;

    private ChatClient chatClient;

    @Value("classpath:/prompts/interview.st")
    private Resource interviewPrompt;

    public ChatService(VectorStore vectorStore, ChatClient.Builder chatClientBuilder) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClientBuilder.build();
    }


    public AssistantMessage generateRoadMap(String message) {
        Prompt prompt = new Prompt(List.of(getSystemMessage(), new UserMessage(message)));
        ChatResponse chatResponse = chatClient.prompt(prompt).call().chatResponse();
        log.info("AI responded.");
        log.info(chatResponse.getResult().getOutput().getContent());
        return chatResponse.getResult().getOutput();
    }

    public Message getSystemMessage() {

        String documents = vectorStore.similaritySearch("java").stream().map(entry -> entry.getContent())
                .collect(Collectors.joining("\n"));
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(interviewPrompt);
        Message systemMessage = systemPromptTemplate.createMessage(Map.of("documents", documents));
        return systemMessage;

    }
}
