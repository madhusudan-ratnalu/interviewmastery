package com.epam.codemastery.InterviewX.model.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;

@Document(collation = "questions")
public class Question {
    @MongoId(FieldType.OBJECT_ID)
    private String _id;
    private ObjectId clientId;
    private ObjectId projectId;
    private ObjectId technologyId;
    private ObjectId candidateId;
    private String question;
    private String component;
    private Timestamp dateCreated;
    private Timestamp dateModified;
    private Boolean isDeleted;
}
