package com.epam.codemastery.InterviewX.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
public class FeedbackModel implements Serializable {
    private CandidateModel candidateDetails;

    private CandidateModel clientDetails;

    private ProjectModel projectDetails;

    private TechnologyModel technologyDetails;

    private List<QuestionsModel> questionList;

}
