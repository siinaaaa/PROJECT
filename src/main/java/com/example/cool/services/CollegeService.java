package com.example.cool.services;

import com.example.cool.dtos.CollegeDto;
import com.example.cool.models.College;
import com.example.cool.models.Teacher;
import com.example.cool.repositories.CollegeRepository;
import com.example.cool.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
    private CollegeRepository collegeRepository;
    private TeacherRepository teacherRepository;

    @Autowired
    public CollegeService(CollegeRepository collegeRepository, TeacherRepository teacherRepository) {
        this.collegeRepository = collegeRepository;
        this.teacherRepository = teacherRepository;
    }

    public String create(CollegeDto collegeDto) {
        College college = this.collegeRepository.findByName(collegeDto.getName());
        Teacher teacher = this.teacherRepository.findByName(collegeDto.getManager().getName());
        if (college.getTeachers().contains(teacher)) {
            this.collegeRepository.save(collegeDto.convertDtotoEntity(collegeDto));
            return "saved";
        }
        return "not saved";
    }
    public CollegeDto read(String name){
        College college = new College();
        return college.convertEntitytoDto(this.collegeRepository.findByName(name));
    }
    public String update(String name, CollegeDto collegeDto){
        this.collegeRepository.deleteById(this.collegeRepository.findByName(name).getId());
        this.collegeRepository.save(collegeDto.convertDtotoEntity(collegeDto));
        return "updated";

    }
    public String delete(String name){
        this.collegeRepository.deleteById(this.collegeRepository.findByName(name).getId());
        return "deleted";
    }
}
