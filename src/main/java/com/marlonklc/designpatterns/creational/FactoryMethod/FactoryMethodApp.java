package com.marlonklc.designpatterns.creational.FactoryMethod;

import com.marlonklc.designpatterns.creational.FactoryMethod.logger.Logger;
import com.marlonklc.designpatterns.creational.FactoryMethod.txt.LoggerTxt;

import java.util.Scanner;

public class FactoryMethodApp {

	public static void main(String[] args) {
		//Logger logger = new LoggerConsole();
		Logger logger = new LoggerTxt();

		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNext()) {
			String textMessage = scanner.nextLine();
			logger.log(textMessage);
		}
	}
}
