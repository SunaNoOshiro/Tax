package com.epam.ryndych.menu.command;

import com.epam.ryndych.Main;
import com.epam.ryndych.menu.HelpInfo;

public class Help implements Command {
	public static final String NAME = "Help";

	@Override
	public void execute() {
		Main.LOG.info("help command execute");
		new HelpInfo();
	}

	@Override
	public String name() {
		return NAME;
	}

}
