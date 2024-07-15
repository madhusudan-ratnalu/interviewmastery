package com.epam.codemastery.InterviewX.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;

@Document(collation = "clients")
public class Client {
    @MongoId(FieldType.OBJECT_ID)
    private String _id;
    private String clientCode;
    private String country;
    private String clientName;
    private Timestamp dateCreated;
    private Timestamp dateModified;
    private Boolean isDeleted;
}
