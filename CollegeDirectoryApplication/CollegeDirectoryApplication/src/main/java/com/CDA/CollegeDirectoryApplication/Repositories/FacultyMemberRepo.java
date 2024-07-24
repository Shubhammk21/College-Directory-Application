package com.CDA.CollegeDirectoryApplication.Repositories;

import com.CDA.CollegeDirectoryApplication.Modules.FacultyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyMemberRepo extends JpaRepository<FacultyMember, Long> {
}
