package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.mappers.ProjectMapper;
import com.epam.codemastery.InterviewX.model.ProjectModel;
import com.epam.codemastery.InterviewX.model.entity.Client;
import com.epam.codemastery.InterviewX.model.entity.Project;
import com.epam.codemastery.InterviewX.repository.ClientRepository;
import com.epam.codemastery.InterviewX.repository.ProjectRepository;
import com.epam.codemastery.InterviewX.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;
    private final ProjectMapper projectMapper;
    @Override
    public List<ProjectModel> getProjects() {
        List<Project> projectList = projectRepository.findAll();
        return projectMapper.clientEntityListToModelList(projectList);
    }

    @Override
    public ProjectModel saveProject(ProjectModel projectModel) throws BadRequestException {
        setDefaultFields(projectModel);
        Client client = clientRepository.findById(projectModel.getClientId()).orElseThrow(() -> new BadRequestException("Invalid clientId"));
        Project project = projectMapper.modelToEntity(projectModel);
        project.setClientId(client.get_id());
        project = projectRepository.save(project);
        return projectMapper.entityToModel(project);
    }

    private void setDefaultFields(ProjectModel projectModel) {
        projectModel.setDateCreated(new Date());
        projectModel.setDateModified(new Date());
        projectModel.setIsDeleted(false);
    }
}
