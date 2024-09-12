package com.epam.codemastery.InterviewX.repository;

import com.epam.codemastery.InterviewX.model.entity.Project;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface ProjectRepository extends MongoRepository<Project, ObjectId> {
    Optional<Project> findBy_idAndIsDeleted(ObjectId projectId, Boolean isDeleted);

    List<Project> findAllByIsDeleted(Boolean isDeleted);
}
