package com.example.cool.controllers;

import com.example.cool.dtos.CollegeDto;
import com.example.cool.models.College;
import com.example.cool.models.Teacher;
import com.example.cool.services.CollegeService;
import com.example.cool.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {
    private CollegeService collegeService;
    private TeacherService teacherService;

    @Autowired
    public CollegeController(CollegeService collegeService, TeacherService teacherService) {
        this.collegeService = collegeService;
        this.teacherService = teacherService;
    }

    @GetMapping(value = "createCollege")
    public String create(@RequestBody CollegeDto collegeDto) {
        College college = this.collegeService.findByname(collegeDto.getName());
        Teacher teacher = this.teacherService.findByname(collegeDto.getManager().getName());
        if (college.getTeachers().contains(teacher)) {
            this.collegeService.save(collegeDto.convertDtotoEntity(collegeDto));
            return "saved";
        }
        return "not save";
    }
    @GetMapping(value = "readCollege")
    public CollegeDto read(@RequestParam String name){
        College college = this.collegeService.findByname(name);
        return college.convertEntitytoDto(college);
    }
    @GetMapping(value = "updateCollege")
    public String update(@RequestParam String name, @RequestBody CollegeDto collegeDto){
        College college = this.collegeService.findByname(name);
        this.collegeService.delete(college);
        this.collegeService.save(collegeDto.convertDtotoEntity(collegeDto));
        return "updated";
    }
    @GetMapping(value = "deleteCollege")
    public String delete(@RequestParam String name){
        College college = this.collegeService.findByname(name);
        this.collegeService.delete(college);
        return "deleted";
    }

}
