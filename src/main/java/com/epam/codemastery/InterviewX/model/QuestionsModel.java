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
public class QuestionsModel implements Serializable {

    private String question;
    private String component;
}
