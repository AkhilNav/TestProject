package com.springboot.service;

import com.springboot.model.Employee;


public interface EmployeeService {
	
	boolean isLoanIssued(String ssn);
	
	long getCreditScore(String ssn);
	

	
}
