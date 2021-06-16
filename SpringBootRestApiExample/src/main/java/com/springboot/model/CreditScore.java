package com.springboot.model;

public class CreditScore {
	
	private String ssn;
	private long creditScore;
	
	public CreditScore(String ssn, long creditScore) {
		this.ssn=ssn;
		this.creditScore=creditScore;
	}
	
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public long getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(long creditScore) {
		this.creditScore = creditScore;
	}



}
