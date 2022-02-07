package com.flush.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flush.crud.dao.EmployeeDao;
import com.flush.crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao emplDao;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImpl") EmployeeDao theEmplDao) {
		emplDao = theEmplDao;
	}

	@Override
	@Transactional
	public List<Employee> findall() {
		return emplDao.findall();
	}

	@Override
	@Transactional
	public Employee findById(int emplId) {
		return emplDao.findById(emplId);
	}

	@Override
	@Transactional
	public void save(Employee empl) {
		emplDao.save(empl);
	}

	@Override
	@Transactional
	public void deleteById(int emplId) {
		emplDao.deleteById(emplId);

	}

}
