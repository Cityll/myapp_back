package com.example.myapp.service;

import com.example.myapp.model.Problem;
import com.example.myapp.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    public Problem findProblemById(Long id) {
        return problemRepository.findById(id).orElse(null);
    }
}
