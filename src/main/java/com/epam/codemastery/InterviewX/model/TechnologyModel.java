package com.epam.codemastery.InterviewX.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyModel implements Serializable {

    private String _id;
    private String technologyName;
    private Timestamp dateCreated;
    private Timestamp dateModified;
    private Boolean isDeleted;

}
