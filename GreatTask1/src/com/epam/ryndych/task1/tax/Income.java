package com.epam.ryndych.task1.tax;

public abstract class Income {

	protected static float percentageOfTax;

	abstract public String getIncomeType();

	abstract public float getObtainTaxAmount();

}
