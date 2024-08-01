package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.mappers.CandidateMapper;
import com.epam.codemastery.InterviewX.model.CandidateModel;
import com.epam.codemastery.InterviewX.model.entity.Candidate;
import com.epam.codemastery.InterviewX.repository.CandidateRepository;
import com.epam.codemastery.InterviewX.service.CandidateService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {
@Autowired
    private CandidateMapper candidateMapper;
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public CandidateModel saveCandidate(CandidateModel candidateModel) {
        Candidate candidate = candidateRepository.save(candidateMapper.modelToEntity(candidateModel));
        return candidateMapper.entityToModel(candidate);
    }

    @Override
    public List<CandidateModel> getCandidates() {
        List<Candidate> candidateList = candidateRepository.findAll();
        return candidateMapper.candidateEntityListToModelList(candidateList);
    }

    @Override
    public CandidateModel getCandidateById(String id) {
        Optional<Candidate> candidate = candidateRepository.findById(new ObjectId(id));
        return candidateMapper.entityToModel(candidate.get());
    }

}
