package com.epam.codemastery.InterviewX.model;


import com.epam.codemastery.InterviewX.config.ObjectIdSerializer;
import com.epam.codemastery.InterviewX.service.Auditable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionsModel implements Serializable, Auditable {
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId _id;
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId clientId;
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId projectId;
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId technologyId;
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId candidateId;
    private  String question;
    private  String component;
    private Date dateCreated;
    private Date dateModified;
    private Boolean isDeleted;
    private Boolean isSynced;
}
