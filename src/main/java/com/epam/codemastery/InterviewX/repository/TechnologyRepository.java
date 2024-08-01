package com.epam.codemastery.InterviewX.repository;

import com.epam.codemastery.InterviewX.model.entity.Technology;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TechnologyRepository extends MongoRepository<Technology, ObjectId> {
    Optional<Technology> findBy_idAndIsDeleted(ObjectId techId, Boolean isDeleted);

    List<Technology> findAllByIsDeleted(Boolean isDeleted);
}
