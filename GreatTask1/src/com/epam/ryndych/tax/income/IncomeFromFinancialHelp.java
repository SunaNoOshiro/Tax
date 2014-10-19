package com.epam.ryndych.tax.income;

public class IncomeFromFinancialHelp extends Income {
	public IncomeFromFinancialHelp(float profit) {
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromFinancialHelp(float profit, boolean isResident) {
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromFinancialHelp";
	}

	@Override
	public float getObtainTaxAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
