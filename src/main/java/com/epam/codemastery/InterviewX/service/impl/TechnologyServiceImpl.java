package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.mappers.TechnologiesMapper;
import com.epam.codemastery.InterviewX.model.TechnologyModel;
import com.epam.codemastery.InterviewX.model.entity.Technology;
import com.epam.codemastery.InterviewX.repository.TechnologyRepository;
import com.epam.codemastery.InterviewX.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;
    private TechnologiesMapper technologiesMapper;

    @Override
    public TechnologyModel saveTechnologies(TechnologyModel technologyModel) {
        Technology technology = technologyRepository.save(technologiesMapper.modelToEntity(technologyModel));
        return technologiesMapper.entityToModel(technology);
    }

    @Override
    public List<TechnologyModel> getTechnologies() {
        List<Technology> technologiesModelList = technologyRepository.findAll();
        return technologiesMapper.technologyEntityListToModelList(technologiesModelList);
    }

}
