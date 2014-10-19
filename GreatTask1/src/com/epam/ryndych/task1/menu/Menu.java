package com.epam.ryndych.task1.menu;

import java.util.ArrayList;
import java.util.HashMap;

import com.epam.ryndych.task1.IOWrapper;
import com.epam.ryndych.task1.menu.command.Command;
import com.epam.ryndych.task1.menu.command.Exit;
import com.epam.ryndych.task1.menu.command.Parse;

public class Menu {

	private HashMap<String, Command> commandList = new HashMap<String, Command>();
	private IOWrapper in = IOWrapper.getInstance();
	private boolean isSubMenu = false;
	private boolean isIncorrect = false;

	public Menu() {
		commandList.put(Parse.NAME, new Parse());
		commandList.put(Exit.NAME, new Exit());
	}

	public Menu(ArrayList<Command> subMenu) {
		isSubMenu = true;

		for (Command i : subMenu) {
			commandList.put(i.name(), i);
		}
	}

	public void showMenu() {
		System.out.println("------------------------------");
		System.out.println("Options:");
		for (String i : commandList.keySet()) {
			System.out.println("\t" + i);
		}
	}

	public void execute() {
		while (true) {
			showMenu();
			String key = in.nextString();
			System.out.println("------------------------------");
			if (commandList.get(key) instanceof Command) {
				commandList.get(key).execute();
				isIncorrect = false;
			} else {
				System.out.println("Incorrect input");
				isIncorrect = true;
			}

			if (isSubMenu && !isIncorrect)
				break;
		}
	}
}
