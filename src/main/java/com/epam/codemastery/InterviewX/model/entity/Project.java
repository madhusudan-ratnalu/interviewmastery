package com.epam.codemastery.InterviewX.model.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;

@Document(collation = "project")
public class Project {
    @MongoId(FieldType.OBJECT_ID)
    private String _id;
    private ObjectId clientId;
    private String projectName;
    private String projectCode;
    private Timestamp dateCreated;
    private Timestamp dateModified;
    private Boolean isDeleted;
}
