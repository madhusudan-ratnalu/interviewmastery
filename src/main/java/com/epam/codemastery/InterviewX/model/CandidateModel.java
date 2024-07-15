package com.epam.codemastery.InterviewX.model;

import lombok.Builder;

@Builder
public record CandidateModel(String userName, String email, String firstName, String lastName
        , String epamId, String telescopeProfileUrl, String designation, String designationCode) {
}
