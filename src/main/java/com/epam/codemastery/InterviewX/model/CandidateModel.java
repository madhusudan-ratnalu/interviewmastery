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
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "candidates")
public class CandidateModel implements Serializable, Auditable {
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId _id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String epamId;
    private String telescopeProfileUrl;
    private String designation;
    private String designationCode;
    private Date dateCreated;
    private Date dateModified;
    private Boolean isDeleted;
}
