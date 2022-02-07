package com.flush.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flush.crud.dao.EmployeeDao;
import com.flush.crud.dao.EmployeeRepo;
import com.flush.crud.entity.Employee;

@Service
public class EmployeeServiceImplJpa implements EmployeeService {

	private EmployeeRepo emplRepo;

	@Autowired
	public EmployeeServiceImplJpa(EmployeeRepo theEmplRepo) {
		emplRepo = theEmplRepo;
	}

	@Override

	public List<Employee> findall() {
		return emplRepo.findAll();
	}

	@Override

	public Employee findById(int emplId) {
		Optional<Employee> result = emplRepo.findById(emplId);
		Employee empl = null;
		if (result.isPresent()) {
			empl = result.get();
		} else {
			throw new RuntimeException("Employee with id: " + emplId + " not found");
		}
		return empl;
	}

	@Override

	public void save(Employee empl) {
		emplRepo.save(empl);
	}

	@Override

	public void deleteById(int emplId) {
		emplRepo.deleteById(emplId);

	}

}
