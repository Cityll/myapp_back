package com.example.myapp.controller;

import com.example.myapp.model.Progress;
import com.example.myapp.model.Problem;
import com.example.myapp.model.User;
import com.example.myapp.service.ProgressService;
import com.example.myapp.service.ProblemService;
import com.example.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @Autowired
    private ProblemService problemService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Progress> getAllProgress() {
        return progressService.getAllProgress();
    }

    @PostMapping
    public String saveProgress(@RequestBody Progress progress) {
        Problem problem = problemService.findProblemById(progress.getProblem().getId())
                .orElseThrow(() -> new IllegalArgumentException("Problem not found"));
        progress.setProblem(problem);

        User user = userService.findUserById(progress.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        progress.setUser(user);

        progressService.saveProgress(progress);
        return "진행률 저장 성공!";
    }
}
