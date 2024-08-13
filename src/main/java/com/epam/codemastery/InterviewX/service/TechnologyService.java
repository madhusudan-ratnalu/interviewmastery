package com.epam.codemastery.InterviewX.service;

import com.epam.codemastery.InterviewX.model.TechnologyModel;
import com.epam.codemastery.InterviewX.model.entity.Technology;
import org.bson.types.ObjectId;

import java.util.List;

public interface TechnologyService {
    Technology findByTechnologyId(ObjectId id);
    TechnologyModel saveTechnologies(TechnologyModel technologyModel);
    List<TechnologyModel> getTechnologies();

}
