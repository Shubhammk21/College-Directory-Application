package com.CDA.CollegeDirectoryApplication.Services;

import com.CDA.CollegeDirectoryApplication.DTO.AssignedAdFaDto;
import com.CDA.CollegeDirectoryApplication.DTO.PersonalAndAcademicDto;
import com.CDA.CollegeDirectoryApplication.Exceptions.StudentException;
import com.CDA.CollegeDirectoryApplication.Modules.Course;
import com.CDA.CollegeDirectoryApplication.Modules.Student;
import com.CDA.CollegeDirectoryApplication.Repositories.EnrollmentRepo;
import com.CDA.CollegeDirectoryApplication.Repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImply implements StudentService{
    @Autowired
    private StudentRepo sr;
    @Autowired
    private EnrollmentRepo er;
    @Override
    public PersonalAndAcademicDto viewProfile(Long id) throws StudentException {
        return sr.findByStudentId(id).orElseThrow(()-> new StudentException("Student Not Found"));
    }

    @Override
    public List<Student> SearchForOtherStudents(String name, String dept, String year) throws StudentException {
        return sr.SearchForOther(name,dept,year);
    }

    @Override
    public List<AssignedAdFaDto> contactFacultyAdvisors(Long id) throws StudentException {
        List<AssignedAdFaDto> arr= er.listOfFaculty(id);
        if (arr.isEmpty()){
            throw new StudentException("Not Enrolled any Course yet");
        }
        return arr;
    }
}
