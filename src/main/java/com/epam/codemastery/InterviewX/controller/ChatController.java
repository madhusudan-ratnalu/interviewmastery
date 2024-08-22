package com.epam.codemastery.InterviewX.controller;

import com.epam.codemastery.InterviewX.model.ChatResponse;
import com.epam.codemastery.InterviewX.model.QuestionSearchRequest;
import com.epam.codemastery.InterviewX.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("chat")
@RestController
public class ChatController {

    private final ChatService chatService;

    private final String defaultValue = """
            Could you provide assistance in crafting a succinct two-week roadmap for a software developer intending to enhance their expertise?
             This plan should itemize key topic areas and related high-level questions crucial to their professional growth.
             Each topic and corresponding question should help nourish essential skills and expanding technological proficiency,
             thereby enabling a structured yet efficient learning journey throughout the two weeks.""";


    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @PostMapping("/generate")
    public ResponseEntity<ChatResponse> generateRoadmap(@RequestBody QuestionSearchRequest searchRequest) {
        String response = this.chatService.generateRoadMap(searchRequest, defaultValue).getContent();
        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setResponse(response);
        return new ResponseEntity<>(chatResponse, HttpStatus.OK);
    }


}