package com.epam.ryndych.tax.income;

import com.epam.ryndych.Main;

public class IncomeFromMainJob extends Income {	
	public IncomeFromMainJob(float profit) {
		Main.LOG.info("IncomeFromMainJob create");
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromMainJob(float profit, boolean isResident) {
		Main.LOG.info("IncomeFromMainJob create");
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromMainJob";
	}

}
