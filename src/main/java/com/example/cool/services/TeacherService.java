package com.example.cool.services;

import com.example.cool.models.Teacher;
import com.example.cool.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher findByname(String name) {
        return this.teacherRepository.findByName(name);
    }
}
