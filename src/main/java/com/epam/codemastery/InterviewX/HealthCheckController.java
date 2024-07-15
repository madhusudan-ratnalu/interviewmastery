package com.epam.codemastery.InterviewX;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siddharth_dwivedi
 * 15th July 2024
 * Controller Class to Check Health of Application
 */
@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public String healthCheck() {
        return "InterviewX Mastery Platform Is Up and Running !!";
    }
}
