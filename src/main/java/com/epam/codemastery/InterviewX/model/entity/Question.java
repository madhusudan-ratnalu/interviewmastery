package com.epam.codemastery.InterviewX.model.entity;

import com.epam.codemastery.InterviewX.service.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "questions")
public class Question implements Auditable {
    @MongoId(FieldType.OBJECT_ID)
    private String _id;
    private ObjectId clientId;
    private ObjectId projectId;
    private ObjectId technologyId;
    private ObjectId candidateId;
    private String question;
    private String component;
    private Date dateCreated;
    private Date dateModified;
    private Boolean isDeleted;

}
