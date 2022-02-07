package com.flush.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flush.crud.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override

	public List<Employee> findall() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override

	public Employee findById(int emplId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee empl = currentSession.get(Employee.class, emplId);
		return empl;
	}

	@Override
	public void save(Employee empl) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(empl);

	}

	@Override
	public void deleteById(int emplId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Employee where id=:id");
		query.setParameter("id", emplId);
		query.executeUpdate();

	}

}
