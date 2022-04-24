package com.marlonklc.designpatterns.creational.FactoryMethod.console;

import com.marlonklc.designpatterns.creational.FactoryMethod.logger.LogPrinter;
import com.marlonklc.designpatterns.creational.FactoryMethod.logger.Logger;

/**
 * Created by Marlon on 10/07/2017.
 */
public class LoggerConsole extends Logger {

	protected LogPrinter createLogger() {
		return new LogPrinterConsole();
	}
}
