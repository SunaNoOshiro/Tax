package com.epam.ryndych.tax.income;

public class IncomeFromRemittances extends Income {
	public IncomeFromRemittances(float profit) {
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromRemittances(float profit, boolean isResident) {
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromRemittances";
	}
}