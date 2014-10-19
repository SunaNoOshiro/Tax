package com.epam.ryndych.tax.income;

import com.epam.ryndych.tax.Tax;

public abstract class Income {
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
		if (profit > 10 * Tax.MIN_WAGE)
			taxRate = profit * 0.17f;
		else
			taxRate = profit * 0.15f;
	}

	protected void calculateForNonResident() {
		taxRate = 0;
	}

	abstract public String getIncomeType();

	public float getObtainTaxAmount(){
		return taxRate;
	}

}
