package com.CDA.CollegeDirectoryApplication.Services;

import com.CDA.CollegeDirectoryApplication.DTO.ViewListOfStudentDto;
import com.CDA.CollegeDirectoryApplication.Exceptions.FacultyMemberException;
import com.CDA.CollegeDirectoryApplication.Modules.FacultyMember;

import java.util.List;

public interface FacultyAdvisorsService {

    public List<ViewListOfStudentDto> manageClassList(Long id) throws FacultyMemberException;

    public FacultyMember updateProfile(FacultyMember fm) throws FacultyMemberException;
}
