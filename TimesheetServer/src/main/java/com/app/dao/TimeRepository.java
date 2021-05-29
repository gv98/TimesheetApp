package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.entity.TimeReport;

@CrossOrigin("http://localhost:4200/")
@Repository
public interface TimeRepository extends JpaRepository<TimeReport, Integer> {
//	@Query
//	(value=" select l.empidl,e.name,l.dat,l.attendance "
//			+ "from logbook l inner join employee e "
//			+ "on l.empidl=e.empid and l.dat= :stri;",nativeQuery=true)
//	public List<TimeReport> getCustomDatesReport(@Param("stri") String str);
	
//	@Query
//	(value=" select empid,name,dat,attendance from "
//			+ "logbook join employee "
//			+ "on dat in(select dat from logbook where dat= :stri)",nativeQuery=true)
//	public List<TimeReport> getCustomDatesReport(@Param("stri") String str);
	
	@Query
	(value=" select empid,name,dat,attendance,status from logbook l join "
			+ "employee e on e.empid=l.empidl and l.dat= :stri and l.status!='saved' order by empid",nativeQuery=true)
	public List<TimeReport> getCustomDatesReport(@Param("stri") String str);
	@Query
	(value=" update logbook set status='approved' where empidl= :empid and dat= :dat",nativeQuery=true)
	public void approveTime(@Param("empid") int empid,@Param("dat") String dat);
	

}
