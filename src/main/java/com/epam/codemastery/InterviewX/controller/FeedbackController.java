package com.epam.codemastery.InterviewX.controller;

import com.epam.codemastery.InterviewX.model.FeedbackModel;
import com.epam.codemastery.InterviewX.service.FeedbackService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController()
@RequiredArgsConstructor
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("interview/feedback")
    public FeedbackModel postFeedback(@RequestBody FeedbackModel feedbackModel) {
        return feedbackService.saveFeedback(feedbackModel);
    }
}
