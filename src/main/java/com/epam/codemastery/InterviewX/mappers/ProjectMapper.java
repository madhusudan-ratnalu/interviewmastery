package com.epam.codemastery.InterviewX.mappers;

import com.epam.codemastery.InterviewX.config.MapperConfig;
import com.epam.codemastery.InterviewX.model.ClientModel;
import com.epam.codemastery.InterviewX.model.ProjectModel;
import com.epam.codemastery.InterviewX.model.entity.Project;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = MapperConfig.class)
public abstract class ProjectMapper {
    public abstract List<ProjectModel> clientEntityListToModelList(List<Project> projectList);
   // @Mapping(target = "clientId", source = "clientId", qualifiedByName = "setObjectId")
    public abstract Project modelToEntity(ProjectModel projectModel);

    //@Named("setObjectId")
   // public ObjectId setObjectId(ObjectId clientId) {
   //    return new ObjectId(clientId);
    //}

    public abstract ProjectModel entityToModel(Project project);

}