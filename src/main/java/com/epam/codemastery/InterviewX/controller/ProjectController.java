package com.epam.codemastery.InterviewX.controller;

import com.epam.codemastery.InterviewX.model.ProjectModel;
import com.epam.codemastery.InterviewX.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * This API will return all projects
     *@return List<ProjectModel>
     */
    @GetMapping()
    public List<ProjectModel> getProjects() {
        return projectService.getProjects();
    }

    /**
     * This API will store new project details.
     * @param projectModel
     * @return projectModel
     */
    @PostMapping()
    public ProjectModel saveProject(@RequestBody ProjectModel projectModel) throws BadRequestException {
        return projectService.saveProject(projectModel);
    }
}
