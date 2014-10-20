package com.epam.ryndych;

public class IncomeException extends Exception {
	public IncomeException() {

	}

	public void print() {
		System.out.println("IncomeException");
	}

	public String getMassage() {
		return "IncomeException";
	}
}
