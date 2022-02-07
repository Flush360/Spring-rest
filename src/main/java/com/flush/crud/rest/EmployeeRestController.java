package com.flush.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flush.crud.entity.Employee;
import com.flush.crud.service.EmployeeService;
import com.flush.crud.service.EmployeeServiceImplJpa;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeServiceImplJpa EmployeeServiceImplJpa;

	@Autowired
	public EmployeeRestController(EmployeeServiceImplJpa theEmployeeServiceImplJpa) {
		EmployeeServiceImplJpa = theEmployeeServiceImplJpa;
	}

	@GetMapping("/employees")
	public List<Employee> findall() {
		return EmployeeServiceImplJpa.findall();
	}

	@GetMapping("/employees/{emplId}")
	public Employee getEmployee(@PathVariable int emplId) {
		Employee empl = EmployeeServiceImplJpa.findById(emplId);
		if (empl == null) {
			throw new RuntimeException("Employee with id: " + emplId + " not found");
		}

		return empl;

	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmpl) {
		theEmpl.setId(0);
		EmployeeServiceImplJpa.save(theEmpl);
		return theEmpl;
	}

	@PatchMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmpl) {
		EmployeeServiceImplJpa.save(theEmpl);
		return theEmpl;

	}

	@DeleteMapping("/employees/{emplId}")
	public String deleteEmployee(@PathVariable int emplId) {
		Employee theEmpl = EmployeeServiceImplJpa.findById(emplId);
		if (theEmpl == null) {
			throw new RuntimeException("Employee with id: " + emplId + " not found");
		}
		EmployeeServiceImplJpa.deleteById(emplId);
		return "Deleted employee with id: " + emplId;
	}

}
