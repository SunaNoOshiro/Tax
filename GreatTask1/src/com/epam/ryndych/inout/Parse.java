package com.epam.ryndych.inout;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.epam.ryndych.Main;
import com.epam.ryndych.exception.IncomeCreateException;
import com.epam.ryndych.tax.Taxpayer;
import com.epam.ryndych.tax.income.Income;
import com.epam.ryndych.tax.income.IncomeFromAdditionalJobs;
import com.epam.ryndych.tax.income.IncomeFromBenefitsForChildren;
import com.epam.ryndych.tax.income.IncomeFromCashGifts;
import com.epam.ryndych.tax.income.IncomeFromFinancialHelp;
import com.epam.ryndych.tax.income.IncomeFromMainJob;
import com.epam.ryndych.tax.income.IncomeFromPropertyGifts;
import com.epam.ryndych.tax.income.IncomeFromRemittances;
import com.epam.ryndych.tax.income.IncomeFromRoyalty;
import com.epam.ryndych.tax.income.IncomeFromSaleOfProperty;

public class Parse {

	private IOWrapper in;
	private HashMap<String, String> list;
	private ArrayList<Income> listOfIncomes;
	private ArrayList<Taxpayer> listOfTaxpayers;
	private Taxpayer currentTaxpayer;
	private ArrayList<String> fromFile;

	public Parse() {
		Main.LOG.info("ParseOfConsole() executing");
		in = IOWrapper.getInstance();
	}

	public void search() {
		Main.LOG.info("findTaxpayer() executing");
		readFromFile();
		init();

		String line = in.nextLine();
		Main.LOG.info("getTaxpayer() executing");
		do {
		} while (!read());

		createIncomeObjects();

		for (Taxpayer i : listOfTaxpayers) {
			if (i.getName().compareToIgnoreCase(currentTaxpayer.getName()) == 0) {
				System.out.println(i.toString());
			}
		}
	}

	public void readTaxpayersFromFile() {
		Main.LOG.info("findTaxpayer() executing");
		readFromFile();
		init();

		String line = in.nextLine();
		for (Taxpayer i : listOfTaxpayers)
			System.out.println(i.toString());
	}

	public Taxpayer getTaxpayer() {// отримати поточного плптника податків
		Main.LOG.info("getTaxpayer() executing");
		do {
		} while (!read());//читає з консолі
		createIncomeObjects();//створює об'єкти доходві
		System.out.println(currentTaxpayer);
		return currentTaxpayer;
	}

	private void createIfHasNotResidentField() {
		//якщо вказано поле 'резидент'
		String isFamilyString;
		for (String i : list.keySet()) {//створює об'єкти 'доходи' в залежності від ключа
			switch (i.toLowerCase()) {
			case "mainjob":
				listOfIncomes.add(new IncomeFromMainJob(Float.parseFloat(list.get(i))));
				break;
			case "additionaljobs":
				listOfIncomes.add(new IncomeFromAdditionalJobs(Float.parseFloat(list.get(i))));
				break;
			case "cashgifts":
				isFamilyString = list.get("isfamily");
				if (isFamilyString == null) {
					listOfIncomes.add(new IncomeFromCashGifts(Float.parseFloat(list.get(i))));
				} else {
					listOfIncomes.add(new IncomeFromCashGifts(Float.parseFloat(list.get(i)), 
							Boolean.parseBoolean(isFamilyString)));
				}
				break;
			case "financialhelp":
				listOfIncomes.add(new IncomeFromFinancialHelp(Float.parseFloat(list.get(i))));
				break;
			case "benefitsforchildren":
				listOfIncomes.add(new IncomeFromBenefitsForChildren(Float.parseFloat(list.get(i))));
				break;
			case "propertygifts":
				isFamilyString = list.get("isfamily");
				if (isFamilyString == null) {
					listOfIncomes.add(new IncomeFromPropertyGifts(Float.parseFloat(list.get(i))));
				} else {
					listOfIncomes.add(new IncomeFromPropertyGifts(Float.parseFloat(list.get(i)),
							Boolean.parseBoolean(isFamilyString)));
				}
				break;
			case "remittances":
				listOfIncomes.add(new IncomeFromRemittances(Float.parseFloat(list.get(i))));
				break;
			case "royalty":
				listOfIncomes.add(new IncomeFromRoyalty(Float.parseFloat(list.get(i))));
				break;
			case "saleofproperty":
				listOfIncomes.add(new IncomeFromSaleOfProperty(Float.parseFloat(list.get(i))));
				break;

			default:
				try {
					throw new IncomeCreateException();
				} catch (IncomeCreateException e) {
					Main.LOG.error(e.getMassage());
				}
			}
		}
	}

	private void createIfHasResidentField(String isResidentString,boolean isFamily) {
		//якщо не вказано поля 'резидент'
		boolean isResident = Boolean.parseBoolean(isResidentString);
		String areaString = list.get("area");
		String priceString = list.get("price");
		if (priceString != null && areaString != null) {
		//якщо введені додаткові поля що стосуються поля 'продажу майна'
			if (priceString != null || areaString != null) {
				listOfIncomes.add(new IncomeFromSaleOfProperty(Float
						.parseFloat(priceString), Float.parseFloat(areaString),
						isResident));
			}
		}

		for (String i : list.keySet()) {
			switch (i.toLowerCase()) {
			case "mainjob":
				listOfIncomes.add(new IncomeFromMainJob(Float.parseFloat(list.get(i)), isResident));
				break;
			case "additionaljobs":
				listOfIncomes.add(new IncomeFromAdditionalJobs(Float.parseFloat(list.get(i)), isResident));
				break;
			case "cashgifts":
				listOfIncomes.add(new IncomeFromCashGifts(Float.parseFloat(list.get(i)), isResident, isFamily));
				break;
			case "financialhelp":
				listOfIncomes.add(new IncomeFromFinancialHelp(Float.parseFloat(list.get(i)), isResident));
				break;
			case "benefitsforchildren":
				listOfIncomes.add(new IncomeFromBenefitsForChildren(Float.parseFloat(list.get(i)), isResident));
				break;
			case "propertygifts":
				listOfIncomes.add(new IncomeFromPropertyGifts(Float.parseFloat(list.get(i)), isResident, isFamily));
				break;
			case "remittances":
				listOfIncomes.add(new IncomeFromRemittances(Float.parseFloat(list.get(i)), isResident));
				break;
			case "royalty":
				listOfIncomes.add(new IncomeFromRoyalty(Float.parseFloat(list.get(i)), isResident));
				break;
			case "saleofproperty":
				listOfIncomes.add(new IncomeFromSaleOfProperty(Float.parseFloat(list.get(i)), isResident));

				break;
			default:
				try {
					throw new IncomeCreateException();
				} catch (IncomeCreateException e) {
					Main.LOG.error(e.getMassage());
				}
			}
		}
	}

	private void createIncomeObjects() {
		listOfIncomes = new ArrayList<Income>();
		String name = list.get("name");
		String isResidentString = list.get("isresident");
		String isFamilyString = list.get("isfamily");
		boolean isFamily;

		if (name == null)
			//якщо не введено ім'я то воно буде рівне 'анонімус'
			name = "anonimus";

		if (isResidentString == null) {
			//якщо не введено чи є платник резидентом
			createIfHasNotResidentField();
		} else {
			
			if (isFamilyString != null)
				//чи введено поле ,що означає шо подарунок від членів сім'ї
				isFamily = Boolean.parseBoolean(isResidentString);
			else
				isFamily = true;

			createIfHasResidentField(isResidentString, isFamily);
		}

		currentTaxpayer = new Taxpayer(name, listOfIncomes);
	}

	private boolean read() {//читає з консолі і записує в файл
		list = new HashMap<String, String>();
		String line = in.nextLine();
		String[] tokens = line.split(" ");
		writeToFile(line);
		return chackToken(tokens);
	}

	private void init() {//
		//ініціалізація
		Main.LOG.info("init() executing");
		listOfTaxpayers = new ArrayList<Taxpayer>();
		for (String s : fromFile) {
			list = new HashMap<String, String>();
			listOfIncomes = new ArrayList<Income>();
			String[] tokens = s.split(" ");
			if (chackToken(tokens)) {
				createIncomeObjects();
				listOfTaxpayers.add(currentTaxpayer);

			}

		}
	}

	private boolean readFromFile() {
		Main.LOG.info("readFromFile() executing");
		try (FileInputStream fis = new FileInputStream("iofile.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis = new DataInputStream(bis);) {

			fromFile = new ArrayList<String>();
			String line;
			while (dis.available() != 0) {
				line = dis.readLine();
				fromFile.add(line);
			}

		} catch (FileNotFoundException e) {
			Main.LOG.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			Main.LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	private boolean writeToFile(String string) {
		Main.LOG.info("writeToFile() executing");
		try (FileWriter fw = new FileWriter("iofile.txt", true);) {
			fw.write("\n" + string);
			return true;
		} catch (FileNotFoundException e) {
			Main.LOG.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			Main.LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	private boolean chackToken(String[] tokens) {
		Main.LOG.info("chackToken() executing");
		for (String i : tokens) {
			String[] par = i.split("[=,-]");
		//парсить текст і повертає чи правильно введені дані
			if (par.length == 2) {
				switch (par[0].toLowerCase()) {
				case "name":
					if (isText(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out.println("Incorrect value of 'name'");
						return false;
					}
					break;
				case "mainjob":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out.println("Incorrect value of 'mainJob'");
						return false;
					}
					break;
				case "additionaljobs":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out
								.println("Incorrect value of 'additionlJobs'");
						return false;
					}
					break;
				case "cashgifts":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out.println("Incorrect value of 'cashGifts'");
						return false;
					}
					break;
				case "financialhelp":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out
								.println("Incorrect value of 'financialHelp'");
						return false;
					}
					break;
				case "benefitsforchildren":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out
								.println("Incorrect value of 'benefitsForChildren'");
						return false;
					}

					break;
				case "propertygifts":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out
								.println("Incorrect value of 'propertyGifts'");
						return false;
					}
					break;
				case "remittances":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out.println("Incorrect value of 'remittances'");
						return false;
					}
					break;
				case "royalty":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out.println("Incorrect value of 'royalty'");
						return false;
					}
					break;
				case "saleofproperty":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out
								.println("Incorrect value of 'saleOfProperty'");
						return false;
					}
					break;
				case "isresident":
					if (isBoolean(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out.println("Incorrect value of 'isResident'");
						return false;
					}
					break;
				case "price":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out.println("Incorrect value of 'price'");
						return false;
					}
					break;
				case "area":
					if (isNumber(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out.println("Incorrect value of 'area'");
						return false;
					}
					break;
				case "isfamily":
					if (isBoolean(par[1])) {
						addToList(par[0], par[1]);
					} else {
						System.out.println("Incorrect value of 'isFamily'");
						return false;
					}
					break;
				default:
					Main.LOG.error("Incorrect input of parameters");
					return false;

				}
			} else
				return false;
		}
		return true;
	}

	private void addToList(String key, String value) {
		Main.LOG.info("addToList() executing");
		list.put(key, value);
	}

	private boolean isBoolean(String string) {
		Main.LOG.info("isBoolean() executing");
		if (string.compareToIgnoreCase("true") == 0
				| string.compareToIgnoreCase("false") == 0) {
			return true;
		} else
			return false;
	}

	private boolean isNumber(String string) {
		Main.LOG.info("isNumber() executing");
		if (string == null)
			return false;
		if (string.matches("^[1-9]+$")
				|| string.matches("^[0-9]+[,,.]?[0-9]+$"))
			return true;
		else
			return false;
	}

	private boolean isText(String string) {
		Main.LOG.info("isText() executing");
		if (string == null)
			return false;
		return string.matches("^[a-z,A-Z]+$");
	}

}
