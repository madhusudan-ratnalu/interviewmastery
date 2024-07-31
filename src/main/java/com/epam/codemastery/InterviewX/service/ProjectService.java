package com.epam.codemastery.InterviewX.service;

import com.epam.codemastery.InterviewX.model.ProjectModel;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ProjectService {
    List<ProjectModel> getProjects();

    ProjectModel saveProject(ProjectModel projectModel) throws BadRequestException;
}
