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


    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;

    }

    @GetMapping(value = "createCollege")
    public String create(@RequestBody CollegeDto collegeDto) {
        return this.collegeService.create(collegeDto);
    }

    @GetMapping(value = "readCollege")
    public CollegeDto read(@RequestParam String name) {
        return this.collegeService.read(name);
    }

    @GetMapping(value = "updateCollege")
    public String update(@RequestParam String name, @RequestBody CollegeDto collegeDto) {
        return collegeService.update(name, collegeDto);
    }

    @GetMapping(value = "deleteCollege")
    public String delete(@RequestParam String name) {
        return this.collegeService.delete(name);
    }

}
