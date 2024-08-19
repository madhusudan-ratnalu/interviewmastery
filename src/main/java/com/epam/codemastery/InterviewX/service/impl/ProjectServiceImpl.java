package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.mappers.ProjectMapper;
import com.epam.codemastery.InterviewX.model.ProjectModel;
import com.epam.codemastery.InterviewX.model.entity.Client;
import com.epam.codemastery.InterviewX.model.entity.Project;
import com.epam.codemastery.InterviewX.repository.ClientRepository;
import com.epam.codemastery.InterviewX.repository.ProjectRepository;
import com.epam.codemastery.InterviewX.service.ProjectService;
import com.epam.codemastery.InterviewX.utils.Utility;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Utility.setDefaultFields(projectModel);
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
    public ProjectModel findByProjectId(ObjectId id) {
        Optional<Project> project;
        try {
           project = Optional.ofNullable(projectRepository.findBy_idAndIsDeleted(id, false).orElseThrow(() -> new BadRequestException("Invalid projectId")));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
        return projectMapper.entityToModel(project.get());
    }

}
