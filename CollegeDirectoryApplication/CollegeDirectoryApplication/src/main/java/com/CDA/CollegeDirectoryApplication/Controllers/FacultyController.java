package com.CDA.CollegeDirectoryApplication.Controllers;

import com.CDA.CollegeDirectoryApplication.DTO.AssignedAdFaDto;
import com.CDA.CollegeDirectoryApplication.DTO.ViewListOfStudentDto;
import com.CDA.CollegeDirectoryApplication.Exceptions.FacultyMemberException;
import com.CDA.CollegeDirectoryApplication.Modules.FacultyMember;
import com.CDA.CollegeDirectoryApplication.Services.FacultyAdvisorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {
    @Autowired
    private FacultyAdvisorsService facultyService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<ViewListOfStudentDto>> getFacultyProfile(@PathVariable Long userId) throws FacultyMemberException {
        List<ViewListOfStudentDto> studentDto = facultyService.manageClassList(userId);
        return ResponseEntity.ok(studentDto);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<FacultyMember> updateFacultyProfile(@PathVariable Long userId, @RequestBody FacultyMember profile) throws FacultyMemberException {
        FacultyMember fm= facultyService.updateProfile(profile);
        return ResponseEntity.ok(fm);
    }
}