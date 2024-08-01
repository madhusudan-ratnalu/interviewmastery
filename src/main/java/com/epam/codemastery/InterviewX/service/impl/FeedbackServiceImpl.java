package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.model.CandidateModel;
import com.epam.codemastery.InterviewX.model.FeedbackModel;
import com.epam.codemastery.InterviewX.model.entity.Candidate;
import com.epam.codemastery.InterviewX.model.entity.Question;
import com.epam.codemastery.InterviewX.service.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
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
        validateRequest(feedbackModel);
        CandidateModel candidate = saveCandidateDetails(feedbackModel);
        prepareQuestionsAndSave(feedbackModel, candidate);
        return feedbackModel;
    }

    private void prepareQuestionsAndSave(FeedbackModel feedbackModel, CandidateModel candidate) {
        List<Question> questionList = new ArrayList<>();
        feedbackModel.getQuestionList().stream().forEach(questionsModel -> {
            Question question = new Question();
            question.setCandidateId(candidate.get_id());
            question.setProjectId(feedbackModel.getProjectDetails().get_id());
            question.setTechnologyId(feedbackModel.getTechnologyDetails().get_id());
            question.setClientId(feedbackModel.getClientDetails().get_id());
            question.setQuestion(questionsModel.getQuestion());
            question.setComponent(questionsModel.getComponent());
            setDefaultFields(question);
            questionList.add(question);

        });
        questionService.savaQuestions(questionList);
    }

    private CandidateModel saveCandidateDetails(FeedbackModel feedbackModel) {
        CandidateModel candidate = candidateService.saveCandidate(feedbackModel.getCandidateDetails());
        return candidate;
    }

    private void setDefaultFields(Question question) {
        question.setDateCreated(new Date());
        question.setDateModified(new Date());
        question.setIsDeleted(false);
    }

    private void validateRequest(FeedbackModel feedbackModel) {
        clientService.findByClientId(feedbackModel.getClientDetails().get_id());
        projectService.findByProjectId(feedbackModel.getProjectDetails().get_id());
       // technologyService.findByTechnologyId(feedbackModel.getTechnologyDetails().get_id());
    }
}
