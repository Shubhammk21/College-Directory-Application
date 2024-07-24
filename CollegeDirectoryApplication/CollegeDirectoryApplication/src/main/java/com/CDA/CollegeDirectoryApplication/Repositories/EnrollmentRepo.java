package com.CDA.CollegeDirectoryApplication.Repositories;

import com.CDA.CollegeDirectoryApplication.DTO.AssignedAdFaDto;
import com.CDA.CollegeDirectoryApplication.DTO.ViewListOfStudentDto;
import com.CDA.CollegeDirectoryApplication.Modules.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
    @Query("Select new com.CDA.CollegeDirectoryApplication.DTO.AssignedAdFaDto(u.email, u.phone) " +
            "From Enrollment e INNER Join e.Course c" +
            "INNER Join c.FacultyMember f " +
            "INNER Join f.user u " +
            "INNER Join e.Student s " +
            "Where s.userId= :id")
    public List<AssignedAdFaDto> listOfFaculty(@Param("id") Long id);

    @Query("Select new com.CDA.CollegeDirectoryApplication.DTO.ViewListOfStudentDto(u.name, s.photo, u.email, u.phone)" +
            "From Enrollment e INNER Join e.Course c" +
            "INNER Join c.FacultyMember f " +
            "INNER Join e.Student s " +
            "INNER Join s.User u " +
            "Where f.userId= :id")
    public List<ViewListOfStudentDto> listOfStudentAssigned(@Param("id") Long id);
}
