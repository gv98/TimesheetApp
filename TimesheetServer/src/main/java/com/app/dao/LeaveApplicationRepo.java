package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.LeaveApplication;

@Repository
public interface LeaveApplicationRepo extends JpaRepository<LeaveApplication, Integer> {
@Query(value="select * from leaveappl where empid =:lid",nativeQuery=true)
public List<LeaveApplication> getByLid(@Param("lid") int lid);

@Query(value="update leaveappl set status='approved' where empid= :empid and dat= :dat",nativeQuery=true)
public void approveLeave(@Param("empid") int empid,@Param("dat") String dat);
}
