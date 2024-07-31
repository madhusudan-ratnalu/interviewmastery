package com.epam.codemastery.InterviewX.service;

import com.epam.codemastery.InterviewX.model.TechnologyModel;

import java.util.List;

public interface TechnologyService {
    TechnologyModel saveTechnologies(TechnologyModel technologyModel);
    List<TechnologyModel> getTechnologies();

}
