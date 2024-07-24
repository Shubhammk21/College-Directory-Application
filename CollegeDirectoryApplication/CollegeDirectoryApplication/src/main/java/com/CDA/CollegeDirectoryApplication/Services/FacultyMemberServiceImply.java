package com.CDA.CollegeDirectoryApplication.Services;

import com.CDA.CollegeDirectoryApplication.DTO.AssignedAdFaDto;
import com.CDA.CollegeDirectoryApplication.DTO.ViewListOfStudentDto;
import com.CDA.CollegeDirectoryApplication.Exceptions.FacultyMemberException;
import com.CDA.CollegeDirectoryApplication.Exceptions.StudentException;
import com.CDA.CollegeDirectoryApplication.Modules.FacultyMember;
import com.CDA.CollegeDirectoryApplication.Repositories.EnrollmentRepo;
import com.CDA.CollegeDirectoryApplication.Repositories.FacultyMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FacultyMemberServiceImply implements FacultyAdvisorsService{
    @Autowired
    private FacultyMemberRepo fr;

    @Autowired
    private EnrollmentRepo er;

    @Override
    public List<ViewListOfStudentDto> manageClassList(Long id) throws FacultyMemberException {
        List<ViewListOfStudentDto> arr= er.listOfStudentAssigned(id);
        if (arr.isEmpty()){
            throw new FacultyMemberException("Not Enrolled any Course yet");
        }
        return arr;
    }

    @Override
    public FacultyMember updateProfile(FacultyMember fm) throws FacultyMemberException {
        return fr.save(fm);
    }
}
