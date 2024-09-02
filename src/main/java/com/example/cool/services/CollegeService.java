package com.example.cool.services;

import com.example.cool.dtos.CollegeDto;
import com.example.cool.models.College;
import com.example.cool.repositories.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
    private CollegeRepository collegeRepository;
    @Autowired
    public CollegeService(CollegeRepository collegeRepository){
        this.collegeRepository=collegeRepository;
    }
    public College findByname(String name){
        return this.collegeRepository.findByName(name);
    }
    public void save(College college){
        this.collegeRepository.save(college);
    }
    public void delete(College college){
        this.collegeRepository.deleteById(college.getId());
    }
}
