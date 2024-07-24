package com.CDA.CollegeDirectoryApplication.Repositories;

import com.CDA.CollegeDirectoryApplication.Modules.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepo extends JpaRepository<Administrator, Long> {

}
