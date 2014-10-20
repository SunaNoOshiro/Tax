package com.epam.ryndych.tax.income;

import com.epam.ryndych.Main;

public class IncomeFromFinancialHelp extends Income {
	public IncomeFromFinancialHelp(float profit) {
		Main.LOG.info("IncomeFromFinancialHelp create");
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromFinancialHelp(float profit, boolean isResident) {
		Main.LOG.info("IncomeFromFinancialHelp create");
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
