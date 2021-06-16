package com.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;
import com.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	EmployeeService employeeService; //Service which will do all data retrieval/manipulation work
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	
	@RequestMapping(value = "/loan/", method = RequestMethod.POST)
	public ResponseEntity<?> getLoanSanctionAmount(@RequestBody Employee employee) {
		logger.info("Employee Details: {}", employee);
		long creditscore=0;
		double sanctionLoanAmount=0;
		boolean isAlreadyLoadTaken=employeeService.isLoanIssued(employee.getSsn());
		if(isAlreadyLoadTaken)
			return new ResponseEntity<String>("Loan Already Taken. Please try again after 30 days",HttpStatus.OK);
		else {
			creditscore=employeeService.getCreditScore(employee.getSsn());
			if(creditscore>=700) {
				sanctionLoanAmount=employee.getAnnualIncome()/2;
			}
		}
		return new ResponseEntity<String>("Sanctioned Loan is:"+sanctionLoanAmount, HttpStatus.OK);
	}

	
}