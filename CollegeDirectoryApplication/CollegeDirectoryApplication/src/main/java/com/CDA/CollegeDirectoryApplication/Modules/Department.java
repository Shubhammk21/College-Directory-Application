package com.CDA.CollegeDirectoryApplication.Modules;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "department")
    private List<Student> students;
    @OneToMany(mappedBy = "department")
    private List<FacultyMember> faculty;

    @OneToMany(mappedBy = "department")
    private List<Administrator> administrators;

    @OneToMany(mappedBy = "department")
    private List<Course> courses;
}
