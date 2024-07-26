package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.model.CandidateModel;
import com.epam.codemastery.InterviewX.repository.CandidateRepository;
import com.epam.codemastery.InterviewX.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public CandidateModel saveCandidate(CandidateModel candidateDetails) {
        return candidateRepository.save(candidateDetails);
    }

    @Override
    public List<CandidateModel> getCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<CandidateModel> getCandidateById(String id) {
        return candidateRepository.findById(id);
    }
}
