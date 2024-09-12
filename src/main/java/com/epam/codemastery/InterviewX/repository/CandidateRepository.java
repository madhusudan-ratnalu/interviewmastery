package com.epam.codemastery.InterviewX.repository;

import com.epam.codemastery.InterviewX.model.entity.Candidate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate, ObjectId> {
    Optional<Candidate> findBy_idAndIsDeleted(ObjectId candidateId, Boolean isDeleted);

    List<Candidate> findAllByIsDeleted(Boolean isDeleted);

}
