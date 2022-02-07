package com.flush.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flush.crud.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
