package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.model.entity.Candidate;
import com.epam.codemastery.InterviewX.model.entity.Technology;
import com.epam.codemastery.InterviewX.repository.TechnologyRepository;
import com.epam.codemastery.InterviewX.service.TechnologyService;
import com.epam.codemastery.InterviewX.utils.Utility;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.bson.types.ObjectId;

import com.epam.codemastery.InterviewX.mappers.TechnologiesMapper;
import com.epam.codemastery.InterviewX.model.TechnologyModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    private TechnologyRepository technologyRepository;
    @Autowired
    private TechnologiesMapper technologiesMapper;

    @Override
    public TechnologyModel findByTechnologyId(ObjectId id) {
        Optional<Technology> technology;
        try {
            technology = Optional.ofNullable(technologyRepository.findBy_idAndIsDeleted(id, false).orElseThrow(() -> new BadRequestException("Invalid TechnologyId")));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
        return  technologiesMapper.entityToModel(technology.get());
    }

    @Override
    public TechnologyModel saveTechnologies(TechnologyModel technologyModel) {
        Utility.setDefaultFields(technologyModel);
        Technology technology = technologyRepository.save(technologiesMapper.modelToEntity(technologyModel));
        return technologiesMapper.entityToModel(technology);
    }

    @Override
    public List<TechnologyModel> getTechnologies() {
        List<Technology> technologiesModelList = technologyRepository.findAll();
        return technologiesMapper.technologyEntityListToModelList(technologiesModelList);
    }
}
