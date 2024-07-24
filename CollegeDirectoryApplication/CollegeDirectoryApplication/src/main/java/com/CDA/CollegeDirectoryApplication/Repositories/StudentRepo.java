package com.CDA.CollegeDirectoryApplication.Repositories;

import com.CDA.CollegeDirectoryApplication.DTO.AssignedAdFaDto;
import com.CDA.CollegeDirectoryApplication.DTO.PersonalAndAcademicDto;
import com.CDA.CollegeDirectoryApplication.Modules.Course;
import com.CDA.CollegeDirectoryApplication.Modules.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query("Select new com.CDA.CollegeDirectoryApplication.DTO.PersonalAndAcademicDto(u.name, s.photo, u.email, u.phone, d.course)" +
            "d.courses from Student s" +
            "INNER JOIN s.user u" +
            "INNER JOIN s.department d" +
            "Where s.userId= :id")
    public Optional<PersonalAndAcademicDto> findByStudentId(@Param("id") Long id);

    @Query("Select s from Student s INNER JOIN s.user u" +
            "INNER JOIN s.department d" +
            "Where u.name LIKE %:name%" +
            "OR" +
            "d.name LIKE %:dept%" +
            "s.year LIKE %:year%")
    public List<Student> SearchForOther(String name, String dept, String year);

}

