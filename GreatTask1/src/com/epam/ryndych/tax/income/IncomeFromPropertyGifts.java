package com.epam.ryndych.tax.income;

import com.epam.ryndych.Main;
import com.epam.ryndych.tax.Tax;

public class IncomeFromPropertyGifts extends Income {
	private boolean isfamily = true;

	public IncomeFromPropertyGifts(float profit) {
		Main.LOG.info("IncomeFromPropertyGifts create");
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromPropertyGifts(float profit, boolean isResident,
			boolean isfamily) {
		Main.LOG.info("IncomeFromPropertyGifts create");
		this.profit = profit;
		this.isResident = isResident;
		this.isfamily = isfamily;
		calculateTax();
	}

	public IncomeFromPropertyGifts(float profit, boolean isfamily) {
		Main.LOG.info("IncomeFromPropertyGifts create");
		this.profit = profit;
		this.isfamily = isfamily;
		calculateTax();
	}

	@Override
	protected void calculateForResident() {
		if (isfamily) {
			taxRate = 0;
		} else {
			taxRate = 0.05f;
		}
	}

	@Override
	protected void calculateForNonResident() {
		if (profit > 10 * Tax.MIN_WAGE) {
			taxRate = profit * 0.17f;
		} else {
			taxRate = profit * 0.15f;
		}
	}

	@Override
	public String getIncomeType() {
		return "IncomeFromPropertyGift";
	}

}
