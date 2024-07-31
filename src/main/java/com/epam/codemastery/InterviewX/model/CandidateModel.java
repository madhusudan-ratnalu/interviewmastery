package com.epam.codemastery.InterviewX.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateModel implements Serializable {

    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String epamId;
    private String telescopeProfileUrl;
    private String designation;
    private String designationCode;

}
