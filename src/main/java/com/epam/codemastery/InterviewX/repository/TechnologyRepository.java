package com.epam.codemastery.InterviewX.repository;

import com.epam.codemastery.InterviewX.model.entity.Technology;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TechnologyRepository extends MongoRepository<Technology, ObjectId> {
}
