package com.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.springboot.model.CreditScore;
import com.springboot.model.Employee;



@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	private static List<Employee> employees;
	private static List<CreditScore> creditScores;
	
	static{
		employees= populateDummyUsers();
		creditScores=populateDummyScores();
	}

	
	public Employee findBySSN(String ssn) {
		for(Employee employee : employees){
			if(employee.getSsn().equalsIgnoreCase(ssn)){
				return employee;
			}
		}
		return null;
	}

	public boolean isLoanIssued(String ssn) {
		return findBySSN(ssn)!=null;
	}
	
	public long getCreditScore(String ssn) {
		for(CreditScore cs : creditScores){
			if(cs.getSsn().equalsIgnoreCase(ssn)){
				return cs.getCreditScore();
			}
		}
		return 0;
	}


	private static List<Employee> populateDummyUsers(){
		List<Employee> employee = new ArrayList<Employee>();
		employee.add(new Employee("123456789",30000, 700000));
		employee.add(new Employee("987654321",40000, 800000));
		employee.add(new Employee("654321987",45000, 900000));
		employee.add(new Employee("321654987",50000, 900000));
		return employee;
	}

	private static List<CreditScore> populateDummyScores(){
		List<CreditScore> creditScores = new ArrayList<CreditScore>();
		creditScores.add(new CreditScore("123456789",700));
		creditScores.add(new CreditScore("987654321",800));
		creditScores.add(new CreditScore("654321987",760));
		creditScores.add(new CreditScore("321654987",750));
		creditScores.add(new CreditScore("987654388",800));
		creditScores.add(new CreditScore("654321977",760));
		creditScores.add(new CreditScore("321654999",750));
		return creditScores;
	}
}
