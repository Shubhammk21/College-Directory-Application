package com.CDA.CollegeDirectoryApplication.Services;

import com.CDA.CollegeDirectoryApplication.Exceptions.FacultyMemberException;
import com.CDA.CollegeDirectoryApplication.Exceptions.StudentException;
import com.CDA.CollegeDirectoryApplication.Modules.FacultyMember;
import com.CDA.CollegeDirectoryApplication.Modules.Student;
import com.CDA.CollegeDirectoryApplication.Repositories.FacultyMemberRepo;
import com.CDA.CollegeDirectoryApplication.Repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrationServiceImply implements AdministratorService{
    @Autowired
    private StudentRepo sr;

    @Autowired
    private FacultyMemberRepo fr;

    @Override
    public Student removeStudent(Student st) throws StudentException {
        sr.delete(st);
        return st;
    }

    @Override
    public Student addStudent(Student st) throws StudentException {
        return sr.save(st);
    }

    @Override
    public Student updateStudent(Student st) throws StudentException {
        return sr.save(st);
    }

    @Override
    public FacultyMember removeFacultyMember(FacultyMember fm) throws FacultyMemberException {
        fr.delete(fm);
        return fm;

    }

    @Override
    public FacultyMember addFacultyMember(FacultyMember fm) throws FacultyMemberException {
        return fr.save(fm);
    }

    @Override
    public FacultyMember updateFacultyMember(FacultyMember fm) throws FacultyMemberException {
        return fr.save(fm);
    }

    @Override
    public List<FacultyMember> listOfFacultyMember() {
        return null;
    }

    @Override
    public List<Student> listOfStudent() {
        return null;
    }
}
