package com.epam.ryndych.task1.menu.command;

import com.epam.ryndych.task1.menu.ParseOfConsole;


public class Parse implements Command {
	public static final String NAME = "Parse";
	@Override
	public void execute() {

		new ParseOfConsole();
	}

	@Override
	public String name() {
		return NAME;
	}

}
