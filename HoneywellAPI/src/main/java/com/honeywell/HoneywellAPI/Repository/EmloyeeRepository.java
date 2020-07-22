package com.honeywell.HoneywellAPI.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.honeywell.HoneywellAPI.Entity.Employee;

@Repository
public interface EmloyeeRepository extends JpaRepository<Employee, Long> {
	
	@Transactional
	@Query("select e from Employee e where e.gender =:gender and e.age > :minage and e.age <:maxage")
	List<Employee> findEmpByAgeandGender(String gender,Integer minage,Integer maxage);

	

}
