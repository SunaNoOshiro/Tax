package com.epam.ryndych.tax.income;

import com.epam.ryndych.Main;

public class IncomeFromRemittances extends Income {
	public IncomeFromRemittances(float profit) {
		Main.LOG.info("IncomeFromRemittances create");
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromRemittances(float profit, boolean isResident) {
		Main.LOG.info("IncomeFromRemittances create");
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromRemittances";
	}
}