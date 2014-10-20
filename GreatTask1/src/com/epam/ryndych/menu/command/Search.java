package com.epam.ryndych.menu.command;

import com.epam.ryndych.IncomeException;
import com.epam.ryndych.Main;
import com.epam.ryndych.menu.Parse;

public class Search implements Command {
	public static final String NAME = "Search";

	@Override
	public void execute() {
		Main.LOG.info("search command execute");
		try {
			new Parse().findTaxpayer();
		} catch (IncomeException e) {
			Main.LOG.error(e.getMassage());
			e.printStackTrace();
		}
	}

	@Override
	public String name() {
		return NAME;
	}

}
