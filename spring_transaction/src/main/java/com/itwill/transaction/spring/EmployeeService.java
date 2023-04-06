package com.itwill.transaction.spring;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional/*(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)*/
public interface EmployeeService {

	public abstract void registerEmployee(Employee emp);
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public abstract void deleteEmployee(int id);
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public abstract void udpateEmployee(Employee emp);

	public abstract List<Employee> getEmps();
	
	public abstract void increaseSalaryForAll();
	
	

}