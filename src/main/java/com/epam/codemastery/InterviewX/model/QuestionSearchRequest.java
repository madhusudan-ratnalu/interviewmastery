package com.epam.codemastery.InterviewX.model;

import lombok.Data;

@Data
public class QuestionSearchRequest {

    private String clientId;
    private String projectId;
    private String languageId;
    private String seniority;
}
