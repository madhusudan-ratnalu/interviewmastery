package com.epam.codemastery.InterviewX.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document(collection = "clients")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @MongoId(FieldType.OBJECT_ID)
    private ObjectId _id;
    private String clientCode;
    private String country;
    private String clientName;
    private Date dateCreated;
    private Date dateModified;
    private Boolean isDeleted;
}
