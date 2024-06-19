package com.example.myapp.controller;

import com.example.myapp.model.Problem;
import com.example.myapp.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping("/problem/{id}")
    public Problem getProblemById(@PathVariable Long id) {
        return problemService.findProblemById(id);
    }
}
