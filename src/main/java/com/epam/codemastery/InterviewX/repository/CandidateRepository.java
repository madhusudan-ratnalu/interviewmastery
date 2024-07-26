package com.epam.codemastery.InterviewX.repository;

import com.epam.codemastery.InterviewX.model.CandidateModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends MongoRepository<CandidateModel, String> {

}
