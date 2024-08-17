package com.example.cool.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class InterfaceTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Student student;
    @OneToOne
    private Lesson lesson;
    @OneToOne
    private Teacher teacher;
    private int score;

}
