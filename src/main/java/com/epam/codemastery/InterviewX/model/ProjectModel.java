package com.epam.codemastery.InterviewX.model;

import com.epam.codemastery.InterviewX.config.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectModel {
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId _id;
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId clientId;
    private String projectName;
    private String projectCode;
    private Date dateCreated;
    private Date dateModified;
    private Boolean isDeleted;
}
