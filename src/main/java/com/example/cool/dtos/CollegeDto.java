package com.example.cool.dtos;

import com.example.cool.models.College;
import com.example.cool.models.Lesson;
import com.example.cool.models.Student;
import com.example.cool.models.Teacher;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CollegeDto {

    private String name;
    private Teacher manager;
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Lesson> lessons;

    public College convertDtotoEntity(CollegeDto collegeDto) {
        College college = new College();
        college.setManager(collegeDto.getManager());
        college.setLessons(collegeDto.getLessons());
        college.setName(collegeDto.getName());
        college.setTeachers(collegeDto.getTeachers());
        college.setStudents(collegeDto.getStudents());
        return college;
    }

}
