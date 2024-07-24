package com.CDA.CollegeDirectoryApplication.Services;

import com.CDA.CollegeDirectoryApplication.DTO.AssignedAdFaDto;
import com.CDA.CollegeDirectoryApplication.DTO.PersonalAndAcademicDto;
import com.CDA.CollegeDirectoryApplication.Exceptions.StudentException;
import com.CDA.CollegeDirectoryApplication.Modules.Student;
import com.CDA.CollegeDirectoryApplication.Modules.User;

import java.util.List;

public interface StudentService {
    public PersonalAndAcademicDto viewProfile(Long id) throws StudentException;
    public List<Student> SearchForOtherStudents(String name, String dept, String year) throws StudentException;
    public List<AssignedAdFaDto> contactFacultyAdvisors(Long id) throws StudentException;
}
