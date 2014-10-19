package com.epam.ryndych.tax.income;

public class IncomeFromBenefitsForChildren extends Income {
	public IncomeFromBenefitsForChildren(float profit) {
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromBenefitsForChildren(float profit, boolean isResident) {
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromMainJob";
	}
}
