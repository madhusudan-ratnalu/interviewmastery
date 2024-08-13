package com.epam.codemastery.InterviewX.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;

@Document(collection = "technology")
public class Technology {
    @MongoId(FieldType.OBJECT_ID)
    private ObjectId _id;
    private String technologyName;
    private Timestamp dateCreated;
    private Timestamp dateModified;
    private Boolean isDeleted;
}
