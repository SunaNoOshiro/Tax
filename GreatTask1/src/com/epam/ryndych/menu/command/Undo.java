package com.epam.ryndych.menu.command;


public class Undo implements Command {
	public final static String NAME = "Undo";

	@Override
	public void execute() {

	}

	@Override
	public String name() {
		return NAME;
	}

}
