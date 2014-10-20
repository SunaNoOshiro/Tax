package com.epam.ryndych.tax.income;

import java.util.Comparator;
import java.util.Date;

import com.epam.ryndych.Main;
import com.epam.ryndych.tax.Tax;

public class IncomeFromSaleOfProperty extends Income {
	private float price = 0;
	private float area = 120;
	private Date dateOfPurchase = new Date();

	public IncomeFromSaleOfProperty(float price, float area, boolean isResident) {
		Main.LOG.info("IncomeFromSaleOfProperty create");
		this.price = price;
		this.area = area;
		this.isResident = isResident;
		calculateTax();
	}

	public IncomeFromSaleOfProperty(float profit) {
		Main.LOG.info("IncomeFromSaleOfProperty create");
		this.profit = profit;
		calculateTax();
	}

	public IncomeFromSaleOfProperty(float profit, boolean isResident) {
		Main.LOG.info("IncomeFromSaleOfProperty create");
		this.profit = profit;
		this.isResident = isResident;
		calculateTax();
	}

	@Override
	protected void calculateForResident() {
		if (profit == 0) {
			if (dateOfPurchase.before(new Date(2004, 1, 1))) {
				if (area > 120) {
					// визначаємо вартість площі, яка перевищила 120 квадратних
					// метрів та її вартість

					float f = (price / area) * (area - 120);
					// визначимо частку, яка оподатковується за ставкою 1 і 5
					// відсотків відповідно та загальну суму податку з даної
					// операції:
					taxRate = (price - f) * 0.1f + f * 0.05f;

				} else {
					taxRate = (profit) * 0.1f;
				}
			}

		} else {
			taxRate = price * 0.13f;
		}
	}

	@Override
	protected void calculateForNonResident() {
		if (profit == 0) {
			taxRate = price * 0.17f;
		} else if (profit > 10 * Tax.MIN_WAGE) {
			taxRate = profit * 0.17f;
		} else {
			taxRate = profit * 0.15f;
		}

	}

	@Override
	public String getIncomeType() {
		return "IncomeFromSaleOfProperty";
	}
}
