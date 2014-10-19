package com.epam.ryndych;

import java.io.InputStream;
import java.util.Scanner;

public class IOWrapper {

	private static IOWrapper instance = null;
	private Scanner in = null;
	private InputStream stream;

	private IOWrapper() {
		in = new Scanner(System.in);
	}

	public String nextString() {
		return in.next();
	}

	public String nextLine() {
		return in.nextLine();
	}

	public boolean hasNext() {
		return in.hasNext();
	}

	public void parse() {

	}

	public static IOWrapper getInstance() {
		if (instance == null) {
			instance = new IOWrapper();
		}
		return instance;
	}

}
