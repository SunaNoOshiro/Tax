package com.epam.ryndych.menu.command;

import com.epam.ryndych.Main;
import com.epam.ryndych.inout.Parse;

public class Search implements Command  {

	public static final String NAME = "Search";

	@Override
	public void execute() {
		Main.LOG.info("Search command execute");
		
			new Parse().search();
		
	}

	@Override
	public String name() {
		return NAME;
	}

}
