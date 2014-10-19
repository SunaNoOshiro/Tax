package com.epam.ryndych.tax.income;

public class IncomeFromAdditionalJobs extends Income {
	public IncomeFromAdditionalJobs(float profit) {
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromAdditionalJobs(float profit, boolean isResident) {
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromMainJob";
	}

}
