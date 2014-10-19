package com.epam.ryndych.tax.income;

public class IncomeFromRoyalty extends Income {
	public IncomeFromRoyalty(float profit) {
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromRoyalty(float profit, boolean isResident) {
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromRoyalty";
	}
}
