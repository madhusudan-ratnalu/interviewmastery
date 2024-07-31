package com.epam.codemastery.InterviewX.mappers;

import com.epam.codemastery.InterviewX.config.MapperConfig;
import com.epam.codemastery.InterviewX.model.CandidateModel;
import com.epam.codemastery.InterviewX.model.ClientModel;
import com.epam.codemastery.InterviewX.model.entity.Candidate;
import com.epam.codemastery.InterviewX.model.entity.Client;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(config = MapperConfig.class)
@Component
public abstract class CandidateMapper {
    public abstract List<CandidateModel> candidateEntityListToModelList(List<Candidate> candidates);

    public abstract Candidate modelToEntity(CandidateModel candidateModel);

    public abstract CandidateModel entityToModel(Candidate candidate);
}
