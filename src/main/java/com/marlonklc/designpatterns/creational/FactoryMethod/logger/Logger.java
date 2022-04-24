package com.marlonklc.designpatterns.creational.FactoryMethod.logger;

/**
 * Created by Marlon on 10/07/2017.
 */
public abstract class Logger {

	protected abstract LogPrinter createLogger();

	public void log(String textMessage) {
		createLogger().print(textMessage);
	}
}
