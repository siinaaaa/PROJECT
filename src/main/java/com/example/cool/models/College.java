package com.example.cool.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
@Data
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @Size(max = 48, min = 5)
    private String name;
    @OneToOne
    private Teacher manager;
    @OneToMany(mappedBy = "college")
    private List<Student> students;
    @OneToMany(mappedBy = "college")
    private List<Teacher> teachers;
    @OneToMany(mappedBy = "college")
    private List<Lesson> lessons;


}
