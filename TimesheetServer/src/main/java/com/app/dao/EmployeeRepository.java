package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.entity.Employee;

@CrossOrigin("http://localhost:4200/")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
