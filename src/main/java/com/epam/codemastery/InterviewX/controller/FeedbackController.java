package com.epam.codemastery.InterviewX.controller;

import com.epam.codemastery.InterviewX.model.FeedbackModel;
import com.epam.codemastery.InterviewX.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/interview")
@RequiredArgsConstructor
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback")
    public FeedbackModel postFeedback(@RequestBody FeedbackModel feedbackModel) {
        return feedbackService.saveFeedback(feedbackModel);
    }
}
