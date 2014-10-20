package com.epam.ryndych.tax.income;

import com.epam.ryndych.Main;

public class IncomeFromBenefitsForChildren extends Income {
	public IncomeFromBenefitsForChildren(float profit) {
		Main.LOG.info("IncomeFromBenefitsForChildren create");
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromBenefitsForChildren(float profit, boolean isResident) {
		Main.LOG.info("IncomeFromBenefitsForChildren create");
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromMainJob";
	}
}
