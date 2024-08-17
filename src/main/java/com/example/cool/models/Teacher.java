package com.example.cool.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String personalyCode;
    @Size(max = 48)
    private String name;
    @Size(max = 48)
    private String family;
    @Column(unique = true)
    private String nationalCode;
    @ManyToOne
    private College college;
    @ManyToMany(mappedBy = "teachers")
    private List<Lesson> lessons;


}
