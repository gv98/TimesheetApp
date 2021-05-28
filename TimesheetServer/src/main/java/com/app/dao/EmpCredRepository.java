package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.EmpCred;

@Repository
public interface EmpCredRepository extends JpaRepository<EmpCred, Integer> {
@Query(value="select * from employeecred where email= :email",nativeQuery=true)
public Optional<EmpCred> findCredByEmail(@Param("email") String email);
}
