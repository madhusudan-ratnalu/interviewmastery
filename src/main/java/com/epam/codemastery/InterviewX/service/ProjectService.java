package com.epam.codemastery.InterviewX.service;

import com.epam.codemastery.InterviewX.model.ProjectModel;
import com.epam.codemastery.InterviewX.model.entity.Project;
import org.apache.coyote.BadRequestException;
import org.bson.types.ObjectId;

import java.util.List;

public interface ProjectService {
    List<ProjectModel> getProjects();

    ProjectModel saveProject(ProjectModel projectModel);

    ProjectModel findByProjectId(ObjectId id);
}
