package com.epam.codemastery.InterviewX.mappers;

import com.epam.codemastery.InterviewX.config.MapperConfig;
import com.epam.codemastery.InterviewX.model.ClientModel;
import com.epam.codemastery.InterviewX.model.TechnologyModel;
import com.epam.codemastery.InterviewX.model.entity.Client;
import com.epam.codemastery.InterviewX.model.entity.Technology;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(config = MapperConfig.class)
@Component
public abstract class TechnologiesMapper {
    public abstract List<TechnologyModel> technologyEntityListToModelList(List<Technology> technologies);

    public abstract Technology modelToEntity(TechnologyModel technologyModel);

    public abstract TechnologyModel entityToModel(Technology technology);
}
