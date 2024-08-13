package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.model.entity.Question;
import com.epam.codemastery.InterviewX.repository.QuestionRepository;
import com.epam.codemastery.InterviewX.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public void savaQuestions(List<Question> questionList) {
        questionRepository.saveAll(questionList);
    }
}
