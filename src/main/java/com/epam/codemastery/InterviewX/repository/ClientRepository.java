package com.epam.codemastery.InterviewX.repository;

import com.epam.codemastery.InterviewX.model.entity.Client;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, ObjectId> {
    Optional<Client> findBy_idAndIsDeleted(ObjectId clientId, Boolean isDeleted);

    List<Client> findAllByIsDeleted(Boolean isDeleted);
}
