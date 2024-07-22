package com.epam.codemastery.InterviewX.controller;

import com.epam.codemastery.InterviewX.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatService chatService;

    private final String defaultValue = """
             Could you assist in assembling a tailored roadmap plan for a software developer looking 
            to expand their expertise in {technology} over the course of the upcoming {number} level? 
            Please highlight the crucial abilities and technologies to cultivate and provide detailed steps to accomplish each goal.
            This pathway should emphasize the vital skills and technologies to be acquired, along with insights on achieving each step effectively based on real world interview experiences and industry practices.""";


    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/generate")
    public String generateRoadmap(@RequestParam(value = "language", defaultValue = "Java") String language,
                                  @RequestParam(value = "seniority", defaultValue = "Middle") String seniority) {
        String prompt = defaultValue.replace("{technology}", language).replace("{number}", seniority);
        return this.chatService.generateRoadMap(prompt).getContent();
    }


}