package com.CDA.CollegeDirectoryApplication.Services;

import com.CDA.CollegeDirectoryApplication.Exceptions.FacultyMemberException;
import com.CDA.CollegeDirectoryApplication.Exceptions.StudentException;
import com.CDA.CollegeDirectoryApplication.Modules.FacultyMember;
import com.CDA.CollegeDirectoryApplication.Modules.Student;

import java.util.List;

public interface AdministratorService {
    public Student removeStudent(Student st) throws StudentException;
    public Student addStudent(Student st) throws StudentException;
    public Student updateStudent(Student st) throws StudentException;
    public FacultyMember removeFacultyMember(FacultyMember fm) throws FacultyMemberException;
    public FacultyMember addFacultyMember(FacultyMember fm) throws FacultyMemberException;
    public FacultyMember updateFacultyMember(FacultyMember fm) throws FacultyMemberException;
    public List<FacultyMember> listOfFacultyMember();
    public List<Student> listOfStudent();

}
