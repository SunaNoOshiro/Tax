package com.epam.ryndych.tax.income;

public class IncomeFromMainJob extends Income {	
	public IncomeFromMainJob(float profit) {
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromMainJob(float profit, boolean isResident) {
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromMainJob";
	}

}
