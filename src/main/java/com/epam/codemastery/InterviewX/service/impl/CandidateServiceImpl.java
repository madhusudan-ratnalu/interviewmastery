package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.mappers.CandidateMapper;
import com.epam.codemastery.InterviewX.model.CandidateModel;
import com.epam.codemastery.InterviewX.model.entity.Candidate;
import com.epam.codemastery.InterviewX.repository.CandidateRepository;
import com.epam.codemastery.InterviewX.service.CandidateService;
import com.epam.codemastery.InterviewX.utils.Utility;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateMapper candidateMapper;
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public CandidateModel saveCandidate(CandidateModel candidateModel) {
        Utility.setDefaultFields(candidateModel);
        Candidate candidate = candidateRepository.save(candidateMapper.modelToEntity(candidateModel));
        return candidateMapper.entityToModel(candidate);
    }

    @Override
    public List<CandidateModel> getCandidates() {
        List<Candidate> candidateList = candidateRepository.findAll();
        return candidateMapper.candidateEntityListToModelList(candidateList);
    }

    @Override
    public CandidateModel getCandidateById(ObjectId candidateId) {
        Optional<Candidate> candidate;
        try {
            candidate = Optional.ofNullable(candidateRepository.findBy_idAndIsDeleted(candidateId, false).orElseThrow(() -> new BadRequestException("Invalid TechnologyId")));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
        return candidateMapper.entityToModel(candidate.get());
    }

}
