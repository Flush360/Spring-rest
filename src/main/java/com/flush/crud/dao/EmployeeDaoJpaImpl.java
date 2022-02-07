package com.flush.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flush.crud.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findall() {
		Query query = entityManager.createQuery("from Employee");
		List<Employee> res = query.getResultList();
		return res;
	}

	@Override
	public Employee findById(int emplId) {
		Employee empl = entityManager.find(Employee.class, emplId);
		return empl;
	}

	@Override
	public void save(Employee empl) {
		Employee theEmpl = entityManager.merge(empl);
		empl.setId(theEmpl.getId());

	}

	@Override
	public void deleteById(int emplId) {
		Query query = entityManager.createQuery("delete from Employee where id=:id");
		query.setParameter("id", emplId);
		query.executeUpdate();

	}

}
