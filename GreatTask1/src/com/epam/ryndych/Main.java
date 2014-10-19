package com.epam.ryndych;

import org.apache.log4j.Logger;

import com.epam.ryndych.menu.*;

public class Main {
	public static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		LOG.info("Program was started");
		new Menu().execute();
	}
}
