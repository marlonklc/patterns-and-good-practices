package com.marlonklc.designpatterns.creational.FactoryMethod.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Marlon on 11/07/2017.
 */
public class DateTimeUtils {

	public static String timestamp() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
}
