package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.model.TechnologyModel;
import com.epam.codemastery.InterviewX.repository.TechnologyRepository;
import com.epam.codemastery.InterviewX.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public TechnologyModel saveTechnologies(TechnologyModel technologyModel) {
        return technologyRepository.save(technologyModel);
    }

    @Override
    public List<TechnologyModel> getTechnologies() {
        return technologyRepository.findAll();
    }
}
