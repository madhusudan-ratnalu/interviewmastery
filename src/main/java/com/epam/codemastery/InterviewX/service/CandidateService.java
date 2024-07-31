package com.epam.codemastery.InterviewX.service;

import com.epam.codemastery.InterviewX.model.CandidateModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CandidateService {

    CandidateModel saveCandidate(CandidateModel candidateDetails);
    List<CandidateModel> getCandidates();
    CandidateModel getCandidateById(String id);
}
