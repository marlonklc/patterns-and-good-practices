package com.marlonklc.designpatterns.creational.FactoryMethod.console;

import com.marlonklc.designpatterns.creational.FactoryMethod.logger.LogPrinter;
import com.marlonklc.designpatterns.creational.FactoryMethod.utils.DateTimeUtils;

/**
 * Created by Marlon on 10/07/2017.
 */
public class LogPrinterConsole implements LogPrinter {

	public void print(String textMessage) {
		String timestamp = DateTimeUtils.timestamp();
		System.err.println("LOG [" + timestamp + "]: " + textMessage);
	}
}
