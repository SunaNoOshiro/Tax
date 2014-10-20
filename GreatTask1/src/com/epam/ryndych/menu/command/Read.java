package com.epam.ryndych.menu.command;

import com.epam.ryndych.IncomeException;
import com.epam.ryndych.Main;
import com.epam.ryndych.menu.Parse;

public class Read implements Command {
	public static final String NAME = "Read";

	@Override
	public void execute() {
		Main.LOG.info("search command execute");
		
			new Parse().findTaxpayer();
		
	}

	@Override
	public String name() {
		return NAME;
	}

}
