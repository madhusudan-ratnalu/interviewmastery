package com.epam.codemastery.InterviewX.repository;

import com.epam.codemastery.InterviewX.model.TechnologyModel;
import com.epam.codemastery.InterviewX.model.entity.Technology;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TechnologyRepository extends MongoRepository<Technology, String> {


}
