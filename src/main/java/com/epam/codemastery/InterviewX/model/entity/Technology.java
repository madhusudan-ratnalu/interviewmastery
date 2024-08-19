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
@Document(collection = "technology")
public class Technology implements Auditable {
    @MongoId(FieldType.OBJECT_ID)
    private ObjectId _id;
    private String technologyName;
    private Date dateCreated;
    private Date dateModified;
    private Boolean isDeleted;
}
