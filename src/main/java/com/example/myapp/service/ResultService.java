package com.example.myapp.service;

import com.example.myapp.model.Result;
import com.example.myapp.repository.ResultRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultService {
    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public Result saveResult(Result result) {
        System.out.println("Saving result: " + result); // 로그 추가
        return resultRepository.save(result);
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }
}