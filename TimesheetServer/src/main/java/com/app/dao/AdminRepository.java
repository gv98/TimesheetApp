package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.entity.Admin;

@CrossOrigin("http://localhost:4200/")
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
