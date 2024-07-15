package com.epam.codemastery.InterviewX.model.entity;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;

@Document(collation = "candidates")
@Builder
public class Candidate {
    @MongoId(FieldType.OBJECT_ID)
    private String _id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String epamId;
    private String telescopeProfileUrl;
    private String designation;
    private String designationCode;
    private Timestamp dateCreated;
    private Timestamp dateModified;
    private Boolean isDeleted;
}


