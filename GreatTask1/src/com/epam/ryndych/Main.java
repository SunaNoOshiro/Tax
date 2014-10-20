package com.epam.ryndych;
//15.Податки. Визначити суму податкових виплат фізичної особи
//
//за рік із врахуванням доходів з основного і додаткового місць роботи, 
//
//авторських винагород, продажу майна, отримання в подарунок грошових 
//
//сум і майна, переказів з-за кордону, пільг на дітей і матеріальну допомогу. 
//
//Здійснити сортування податків по сумі. Знайти для особи податки, що 
//
//відповідають заданому діапазону параметрів.
import org.apache.log4j.Logger;

import com.epam.ryndych.menu.*;

public class Main {
	public static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		LOG.info("Program was started");
		new Menu().execute();
	}
}
