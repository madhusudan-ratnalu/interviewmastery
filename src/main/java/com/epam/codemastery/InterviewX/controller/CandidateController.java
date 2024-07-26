package com.epam.codemastery.InterviewX.controller;

import com.epam.codemastery.InterviewX.model.CandidateModel;
import com.epam.codemastery.InterviewX.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/save")
    public CandidateModel saveCandidate(@RequestBody CandidateModel candidateModel) {
        return candidateService.saveCandidate(candidateModel);
    }

    @GetMapping("/get")
    public List<CandidateModel> getCandidates() {
        return candidateService.getCandidates();
    }

    @GetMapping("getCandidateById/{id}")
    public Optional<CandidateModel> getCandidateById(@PathVariable String id) {
        return candidateService.getCandidateById(id);
    }

}
