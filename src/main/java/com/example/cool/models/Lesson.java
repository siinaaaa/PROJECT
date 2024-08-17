package com.example.cool.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 64)
    @Column(unique = true)
    private String name;
    private int unit;
    @ManyToOne
    private College college;
    @ManyToMany
    private List<Teacher> teachers;
}
