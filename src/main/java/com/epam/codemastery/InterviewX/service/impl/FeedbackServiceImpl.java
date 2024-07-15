package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.model.FeedbackModel;
import com.epam.codemastery.InterviewX.service.*;
import org.springframework.beans.factory.annotation.Autowired;

public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TechnologyService technologyService;

    @Override
    public FeedbackModel saveFeedback(FeedbackModel feedbackModel) {
        return null;
    }
}
