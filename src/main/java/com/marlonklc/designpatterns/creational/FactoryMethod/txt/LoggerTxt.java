package com.marlonklc.designpatterns.creational.FactoryMethod.txt;

import com.marlonklc.designpatterns.creational.FactoryMethod.logger.LogPrinter;
import com.marlonklc.designpatterns.creational.FactoryMethod.logger.Logger;

/**
 * Created by Marlon on 10/07/2017.
 */
public class LoggerTxt extends Logger {

	protected LogPrinter createLogger() {
		return new LogPrinterTxt();
	}
}
