package com.epam.ryndych.tax.income;

import java.io.Serializable;
import java.util.Comparator;

import com.epam.ryndych.tax.Tax;

public abstract class Income implements Comparable<Income>, Comparator<Income>,Serializable {
	protected float profit = 0;
	protected float taxRate = 0;
	protected boolean isResident = true;

	protected void calculateTax() {
		if (isResident) {
			calculateForResident();
		} else {
			calculateForNonResident();
		}
	}

	protected void calculateForResident() {
		taxRate = profit * 0.13f;
	}

	protected void calculateForNonResident() {
		if (profit > 10 * Tax.MIN_WAGE)
			taxRate = profit * 0.17f;
		else
			taxRate = profit * 0.15f;
	}

	abstract public String getIncomeType();

	public float getObtainTaxAmount() {
		return taxRate;
	}

	@Override
	public int compareTo(Income o) {
		if (taxRate > o.taxRate)
			return 1;
		else if (taxRate < o.taxRate)
			return -1;
		else
			return 0;
	}

	@Override
	public int compare(Income o1, Income o2) {
		if (o1.taxRate > o2.taxRate)
			return 1;
		else if (o1.taxRate < o2.taxRate)
			return -1;
		else
			return 0;
	}

	public static Comparator<Income> IncomeComparator = new Comparator<Income>() {
		public int compare(Income o1, Income o2) {
			return o1.compareTo(o2);
		}

	};
}
