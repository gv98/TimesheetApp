package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.ELogbook;

@Repository
public interface LogbookRepository extends JpaRepository<ELogbook,Integer> {
@Query
(value="select * from logbook where empidl= :id",nativeQuery=true)
public List<ELogbook> timeSheetDash(@Param("id") int id);
@Query
(value="select * from logbook where pid= :id",nativeQuery=true)
public ELogbook getLogById(@Param("id") int id);
}


