package com.honeywell.HoneywellAPI.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.HoneywellAPI.Entity.Employee;
import com.honeywell.HoneywellAPI.Repository.EmloyeeRepository;

@RestController
@EnableTransactionManagement
public class EmployeeController {
	@Autowired
	private EmloyeeRepository employeerepo;
	

	@PostMapping("/honeywell/insertEmployee")
	public Employee insertEmployee(@RequestBody Employee employee) {
		Employee emp = null;
		try {
			 emp=employeerepo.save(employee);
		}
		catch(Exception e) {
			System.out.println("Exception occurred"+e.getMessage());	
		}
		return  emp;
	}
	
	@GetMapping("/honeywell/getEmployee/{gender}/{minage}/{maxage}")
	public List<Employee> getEmployee(@PathVariable Integer minage,@PathVariable Integer maxage ,@PathVariable String gender ) {
		List<Employee> emp = null ;
		try {
				emp=employeerepo.findEmpByAgeandGender(gender,minage,maxage);
				if(emp==null) 
					System.out.println("No Records found for the combination");
		}
		catch(Exception e) {
			System.out.println("Exception occurred"+e.getMessage());
		}
		return  emp;
	}
}
