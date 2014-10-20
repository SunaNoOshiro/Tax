package com.epam.ryndych.menu.command;

import com.epam.ryndych.IncomeException;
import com.epam.ryndych.Main;
import com.epam.ryndych.menu.Parse;

public class Input implements Command {
	public static final String NAME = "Input";

	@Override
	public void execute() {
		Main.LOG.info("input command execute");
		try {
			new Parse().getTaxpayer();
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
