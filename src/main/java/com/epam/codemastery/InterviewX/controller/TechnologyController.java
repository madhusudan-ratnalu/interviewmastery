package com.epam.codemastery.InterviewX.controller;

import com.epam.codemastery.InterviewX.model.TechnologyModel;
import com.epam.codemastery.InterviewX.service.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/technologies")
@RequiredArgsConstructor
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @PostMapping("/save")
    public TechnologyModel saveTechnologiesDetails(@RequestBody TechnologyModel technologyModel) {
        return technologyService.saveTechnologies(technologyModel);
    }
}
