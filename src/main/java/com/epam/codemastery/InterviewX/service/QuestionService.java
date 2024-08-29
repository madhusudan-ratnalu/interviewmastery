package com.epam.codemastery.InterviewX.service;

import com.epam.codemastery.InterviewX.model.entity.Question;

import java.util.List;

public interface QuestionService {
    void savaQuestions(List<Question> questionList);

    List<Question> findQuestionsForSync();

}
