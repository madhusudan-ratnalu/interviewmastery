package com.epam.codemastery.InterviewX.model;


import com.epam.codemastery.InterviewX.service.Auditable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedbackModel implements Serializable {
    private CandidateModel candidateDetails;

    private ClientModel clientDetails;

    private ProjectModel projectDetails;

    private TechnologyModel technologyDetails;

    private List<QuestionsModel> questionList;

}
