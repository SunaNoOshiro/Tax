package com.epam.ryndych.tax.income;

import com.epam.ryndych.Main;

public class IncomeFromRoyalty extends Income {
	public IncomeFromRoyalty(float profit) {
		Main.LOG.info("IncomeFromRoyalty create");
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromRoyalty(float profit, boolean isResident) {
		Main.LOG.info("IncomeFromRoyalty create");
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromRoyalty";
	}
}
