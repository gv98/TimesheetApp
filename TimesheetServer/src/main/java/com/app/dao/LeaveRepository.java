package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.entity.Leaves;

@CrossOrigin("http://localhost:4200/")
@Repository
public interface LeaveRepository extends JpaRepository<Leaves, Integer	> {
@Query(value=" delete from leavetypes where name= :stri",nativeQuery=true)
public void deleteLeave(@Param("stri") String str);
}
