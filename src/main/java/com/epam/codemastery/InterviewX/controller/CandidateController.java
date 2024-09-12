package com.epam.codemastery.InterviewX.controller;

import com.epam.codemastery.InterviewX.model.CandidateModel;
import com.epam.codemastery.InterviewX.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
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

    @PostMapping
    public CandidateModel saveCandidate(@RequestBody CandidateModel candidateModel) {
        return candidateService.saveCandidate(candidateModel);
    }

    @GetMapping
    public List<CandidateModel> getCandidates() {
        return candidateService.getCandidates();
    }

    @GetMapping("/{id}")
    public CandidateModel getCandidateById(@PathVariable ObjectId id) {
        return candidateService.getCandidateById(id);
    }

}
