package com.epam.ryndych.tax.income;

import com.epam.ryndych.Main;

public class IncomeFromAdditionalJobs extends Income {
	
	public IncomeFromAdditionalJobs(float profit) {
		Main.LOG.info("IncomeFromAdditionalJobs create");
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromAdditionalJobs(float profit, boolean isResident) {
		Main.LOG.info("IncomeFromAdditionalJobs create");
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromAdditionalJobs";
	}

}
