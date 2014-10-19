package com.epam.ryndych.tax;

import java.util.ArrayList;

import com.epam.ryndych.tax.income.*;

public class Tax {

	public final static float MIN_WAGE = 1218;
	private ArrayList<Income> listOfIncomes = new ArrayList<Income>();

	public Tax(ArrayList<Income> listOfIncomes) {
		this.listOfIncomes = listOfIncomes;
	}

	public int getNumberOfTaxPayments() {
		return listOfIncomes.size();
	}

	public float getSumOfTaxPayments() {
		float sum = 0;
		for (Income i : listOfIncomes) {
			sum += i.getObtainTaxAmount();
		}
		return sum;
	}
}
