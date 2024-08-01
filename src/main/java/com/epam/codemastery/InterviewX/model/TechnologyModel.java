package com.epam.codemastery.InterviewX.model;


import com.epam.codemastery.InterviewX.config.ObjectIdSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;

import java.util.Date;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TechnologyModel implements Serializable{
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId _id;
    private String technologyName;
    private Date dateCreated;
    private Date dateModified;
    private Boolean isDeleted;
}
