package com.epam.ryndych.menu.command;

import com.epam.ryndych.Main;

public class Exit implements Command {
	public final static String NAME = "Exit";

	@Override
	public void execute() {
		Main.LOG.info("Executing command 'exit' ");
		System.exit(0);
	}

	@Override
	public String name() {
		return NAME;
	}

}
