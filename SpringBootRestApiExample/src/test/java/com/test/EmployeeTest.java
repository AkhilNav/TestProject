package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.springboot.controller.RestApiController;
import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeTest {

	Employee employee;
	
	@Mock
	EmployeeService employeeservice;
	
	@InjectMocks
	RestApiController restController;
	
	    @Test
	    public void testGetLoanSanctionAmount() {
	    	employee =new Employee();
	    	employee.setSsn("654321977");
	        employee.setLoanAmount(10000);
	        employee.setAnnualIncome(200000);
	    	ResponseEntity<?> rs=restController.getLoanSanctionAmount(employee);
	    	assertEquals(rs.getStatusCodeValue(),200);
	    }
	    
	    @Test
	    public void testGetLoanSanctionAmount1() {
	    	employee =new Employee();
	    	employee.setSsn("654321987");
	        employee.setLoanAmount(10000);
	        employee.setAnnualIncome(200000);
	    	ResponseEntity<?> rs=restController.getLoanSanctionAmount(employee);
	    	assertEquals(rs.getStatusCodeValue(),200);
	    }
}
