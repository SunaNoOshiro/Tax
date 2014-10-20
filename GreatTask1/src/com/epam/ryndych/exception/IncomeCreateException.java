package com.epam.ryndych.exception;

public class IncomeCreateException extends Exception {
	public IncomeCreateException() {

	}

	public void print() {
		System.out.println("IncomeCreateException");
	}

	public String getMassage() {
		return "IncomeCreateException";
	}
}
