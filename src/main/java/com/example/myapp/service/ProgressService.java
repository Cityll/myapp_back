package com.example.myapp.service;

import com.example.myapp.model.Progress;
import com.example.myapp.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    public void saveProgress(Progress progress) {
        progressRepository.save(progress);
    }
}
