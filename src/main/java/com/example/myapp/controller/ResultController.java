package com.example.myapp.controller;

import com.example.myapp.model.Result;
import com.example.myapp.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @PostMapping
    public String saveResult(@RequestBody Result result) {
        resultService.saveResult(result);
        return "결과 저장 완료!";
    }
}
