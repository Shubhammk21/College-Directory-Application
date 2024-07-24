package com.CDA.CollegeDirectoryApplication.Controllers;

import com.CDA.CollegeDirectoryApplication.DTO.AssignedAdFaDto;
import com.CDA.CollegeDirectoryApplication.DTO.PersonalAndAcademicDto;
import com.CDA.CollegeDirectoryApplication.Exceptions.StudentException;
import com.CDA.CollegeDirectoryApplication.Modules.Student;
import com.CDA.CollegeDirectoryApplication.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{userId}")
    public ResponseEntity<PersonalAndAcademicDto> getStudentProfile(@PathVariable Long userId) throws StudentException {
        PersonalAndAcademicDto profile = studentService.viewProfile(userId);
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String departmentId,
                                                        @RequestParam(required = false) String year) throws StudentException {
        List<Student> students = studentService.SearchForOtherStudents(name, departmentId, year);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/ListOfAssignedFacultyAdvisors")
    public ResponseEntity<List<AssignedAdFaDto>> AssignedFacultyCon(@RequestParam(required = false) Long id) throws StudentException {
        List<AssignedAdFaDto> faculty = studentService.contactFacultyAdvisors(id);
        return ResponseEntity.ok(faculty);
    }
}
