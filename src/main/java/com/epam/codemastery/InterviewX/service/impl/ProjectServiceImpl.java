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
import org.bson.types.ObjectId;
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
        List<Project> projectList = projectRepository.findAllByIsDeleted(false);
        return projectMapper.clientEntityListToModelList(projectList);
    }

    @Override
    public ProjectModel saveProject(ProjectModel projectModel){
        setDefaultFields(projectModel);
        Client client = null;
        try {
            client = clientRepository.findById(projectModel.getClientId()).orElseThrow(() -> new BadRequestException("Invalid clientId"));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
        Project project = projectMapper.modelToEntity(projectModel);
        project.setClientId(client.get_id());
        project = projectRepository.save(project);
        return projectMapper.entityToModel(project);
    }

    @Override
    public Project findByProjectId(ObjectId id) {
        try {
            return projectRepository.findBy_idAndIsDeleted(id, false).orElseThrow(() -> new BadRequestException("Invalid projectId"));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
    }

    private void setDefaultFields(ProjectModel projectModel) {
        projectModel.setDateCreated(new Date());
        projectModel.setDateModified(new Date());
        projectModel.setIsDeleted(false);
    }
}
