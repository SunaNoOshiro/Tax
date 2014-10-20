package com.epam.ryndych.menu;

import com.epam.ryndych.Main;

public class HelpInfo {
	public HelpInfo() {
		Main.LOG.info("HelpInfo() executing");
		showInfoToConsole();
	}

	private void showInfoToConsole() {
		System.out
				.println("This program determines the number and amount of payment the taxpayer.\n"
						+ "To do this, select the menu item \"Parse\" and according to the following \n"
						+ "abbreviations enter the required information through gap \n"
						+ "\tname\t\t\t: Taxpeyers name :String\n"
						+ "\tisResident\t\t: Is a resident? :Boolean\n"
						+ "\tmainJob\t\t\t: Income from main job :Float\n"
						+ "\tadditionalJobs\t\t: Income from additional work :Float\n"
						+ "\troyalty\t\t\t: Income from royalties :Float\n"
						+ "\tcashGifts\t\t: Income from receiving a gift of money :Float\n"
						+ "\tpropertyGifts\t\t: Income from receiving a gift of property :Float\n"
						+ "\tisFamily\t\t: Is a gift from family :Boolean\n"
						+ "\tremittances\t\t: Income from remittances from abroad :Float\n"
						+ "\tbenefitsForChildren\t: Income with benefits to children :Float\n"
						+ "\tfinancialHelp\t\t: Income from financial aid :Float\n"
						+ "\tsaleOfProperty\t\t: Income from sale of property :Float\n"
						+ "\tarea\t\t\t: Area of the property that was sold :Float\n"
						+ "\tprice\t\t\t: Price of the property which is sold :Float\n"
						+ "\nFor example:\n\n"
						+ "\t name=Petro mainJob=4500 cashGifts=5000 isFamily=true\n\n"
						+ "This means that the taxpayer's name is Petro,\n"
						+ "his income from the main work is 4500,\n"
						+ "his income from receiving monye gift from the family is 5000\n");
	}
}
