package com.awin.test.service;

import com.awin.test.entity.Test;
import com.awin.test.repository.TestRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public List<Test> getLists(){
        return testRepository.findAll();
    }

    public Optional<Test> getData(long id){
        return testRepository.findById(id);
    }

    public void getData(Test test){
        testRepository.save(test);
    }
}
