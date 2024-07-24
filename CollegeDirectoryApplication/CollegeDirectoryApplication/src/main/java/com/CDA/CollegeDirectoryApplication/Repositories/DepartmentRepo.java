package com.CDA.CollegeDirectoryApplication.Repositories;

import com.CDA.CollegeDirectoryApplication.Modules.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
