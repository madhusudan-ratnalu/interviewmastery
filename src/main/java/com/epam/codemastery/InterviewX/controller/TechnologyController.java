package com.epam.codemastery.InterviewX.controller;

import com.epam.codemastery.InterviewX.model.TechnologyModel;
import com.epam.codemastery.InterviewX.service.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/technologies")
@RequiredArgsConstructor
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @PostMapping
    public TechnologyModel saveTechnologies(@RequestBody TechnologyModel technologyModel) {
        return technologyService.saveTechnologies(technologyModel);
    }

    @GetMapping
    public List<TechnologyModel> getTechnologies() {
        return technologyService.getTechnologies();
    }
}
