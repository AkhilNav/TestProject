package com.springboot.model;

public class Employee {
	private String ssn;
	private double loanAmount;
	private double annualIncome;
	
	public Employee(String ssn, double loanAmount, double annualIncome){
		this.ssn = ssn;
		this.loanAmount = loanAmount;
		this.annualIncome = annualIncome;
	}
	
	public Employee() {
		
	}	
	
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	
	

}
