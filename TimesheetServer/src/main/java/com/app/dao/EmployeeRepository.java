package com.app.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.entity.Employee;

@CrossOrigin("http://localhost:4200/")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value="select * from employee where email= :email",nativeQuery=true)
	public  Optional<Employee> getEmpByEmail(@Param("email") String email);
}
