package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
