package com.epam.codemastery.InterviewX.repository;

import com.epam.codemastery.InterviewX.model.entity.Client;
import com.epam.codemastery.InterviewX.model.entity.Question;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends MongoRepository<Question, ObjectId> {
    Optional<Question> findBy_idAndIsDeleted(ObjectId questionId, Boolean isDeleted);

    List<Question> findAllByIsDeleted(Boolean isDeleted);
}
