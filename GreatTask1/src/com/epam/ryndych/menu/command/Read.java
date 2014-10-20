package com.epam.ryndych.menu.command;

import com.epam.ryndych.Main;
import com.epam.ryndych.inout.Parse;

public class Read implements Command {
	public static final String NAME = "Read";

	@Override
	public void execute() {
		Main.LOG.info("search command execute");

		new Parse().readTaxpayersFromFile();

	}

	@Override
	public String name() {
		return NAME;
	}

}
