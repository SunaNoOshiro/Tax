package com.epam.ryndych.tax;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.epam.ryndych.Main;
import com.epam.ryndych.tax.income.*;

public class Tax implements Serializable {

	public final static float MIN_WAGE = 1218;//мінімальна заробітня плата
	private ArrayList<Income> listOfIncomes = new ArrayList<Income>();//список доходів

	public Tax(ArrayList<Income> listOfIncomes) {
		Main.LOG.info("Tax create");
		this.listOfIncomes = listOfIncomes;
	}

	public int getNumberOfTaxPayments() {//повертає кількість податків
		return listOfIncomes.size();
	}

	public float getSumOfTaxPayments() {//повертає суми податків
		float sum = 0;
		for (Income i : listOfIncomes) {
			sum += i.getObtainTaxAmount();
		}
		return sum;
	}

	@Override
	public String toString() {
		Collections.sort(listOfIncomes, Income.IncomeComparator);
		String string = "";
		for (Income i : listOfIncomes) {
			string += "\t" + i.getIncomeType() + "=" + i.getProfit()
					+ ": tax = " + i.getObtainTaxAmount() + "\n";
		}
		return string;
	}
}
