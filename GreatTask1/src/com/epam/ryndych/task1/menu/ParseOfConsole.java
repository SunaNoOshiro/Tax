package com.epam.ryndych.task1.menu;

import java.util.HashMap;

import com.epam.ryndych.task1.IOWrapper;
import com.epam.ryndych.task1.Main;

public class ParseOfConsole {

	private enum Tax {
		BASIC_INCOME("basicIncome") {
		// profit from main jobs
		},
		ADDITIONAL_INCOME("AdditionalIncome") {
		// profit from additional jobs
		},
		ROYALTIES("royalties") {
		// royalties

		},
		SALE_OF_PROPERTY("saleOfProperty") {
		// sale of property

		},

		ÑASH_GIFTS("cashGifts") {
		// receive cash as a gift

		},
		PROPERTY_GIFTS("propertyGifts") {
		// receive a gift of property

		},
		TRANSFERS("transfers") {
		// transfers from abroad

		},
		BENEFITS_FOR_CHILDREN("benefitsForChildren") {
		// benefits for children

		},
		FINANCIAL_HELP("financialHelp") {
		// financial help
		};
		private final String incomeType;

		private Tax(String incomeType) {
			this.incomeType = incomeType;
		}

		public String getIncomeType() {
			return incomeType;
		}
	}

	private IOWrapper in;
	HashMap<String, String> tmp = new HashMap<String, String>();

	public ParseOfConsole() {
		in = IOWrapper.getInstance();

		do {
			tmp = read();
		} while (!chack());

	}

	private HashMap<String, String> read() {
		HashMap<String, String> listOfTaxParametres = new HashMap<String, String>();
		String[] arg;
		String ss =in.nextLine();
			arg = ss.split("[=,-]");
			listOfTaxParametres.put(arg[0], arg[1]);
			System.out.println(arg[0] + ":" + arg[1]);
		
	
		return listOfTaxParametres;
	}

	private boolean chack() {
		
		return true;
	}

}
