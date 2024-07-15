package com.epam.codemastery.InterviewX.service;

import com.epam.codemastery.InterviewX.model.CandidateModel;
import com.epam.codemastery.InterviewX.model.entity.Candidate;
import org.springframework.stereotype.Service;

@Service
public interface CandidateService {
    Candidate saveCandidate(CandidateModel candidateDetails);
}
