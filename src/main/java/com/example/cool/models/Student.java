package com.example.cool.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String studentNumber;
    @Size(max = 48)
    private String name;
    @Size(max = 48)
    private String family;
    private String nationalCode;
    private String address;
    private int avg;
    @ManyToOne
    private College college;
    @OneToMany
    private List<InterfaceTable> interfaceTables;

}
