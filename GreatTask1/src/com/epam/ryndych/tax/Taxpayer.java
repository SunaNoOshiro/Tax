package com.epam.ryndych.tax;

import java.io.Serializable;
import java.util.ArrayList;

import com.epam.ryndych.Main;
import com.epam.ryndych.tax.income.Income;

public class Taxpayer implements Serializable {
	private String name;
	private Tax taxRate;

	public Taxpayer(String name, ArrayList<Income> listOfIncomes) {
		Main.LOG.info("Taxpayer create");
		this.name = name;
		this.taxRate = new Tax(listOfIncomes);
	}

	public int getNumberOfTaxPayments() {
		return taxRate.getNumberOfTaxPayments();
	}

	public float getSumOfTaxPayments() {
		return taxRate.getSumOfTaxPayments();
	}

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name +":\n" +taxRate.toString();
	}

}
