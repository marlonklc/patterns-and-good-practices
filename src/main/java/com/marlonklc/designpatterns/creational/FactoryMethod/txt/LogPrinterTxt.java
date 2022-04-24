package com.marlonklc.designpatterns.creational.FactoryMethod.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import com.marlonklc.designpatterns.creational.FactoryMethod.logger.LogPrinter;
import com.marlonklc.designpatterns.creational.FactoryMethod.utils.DateTimeUtils;

/**
 * Created by Marlon on 10/07/2017.
 */
public class LogPrinterTxt implements LogPrinter {

	private static final Path filePath = Path.of(System.getProperty("user.home"), "fileLog.txt" );

	public void print(String textMessage) {
		try {
			if (Files.notExists(filePath)) {
				Files.createFile(filePath);
			}

			File file = filePath.toFile();

			String textoAtual = getTextByFile(file);
			String dataHoraAtual = DateTimeUtils.timestamp();

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.append(textoAtual);
			writer.newLine();
			writer.append("LOG [" + dataHoraAtual + "]: " + textMessage);

			writer.flush();
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private String getTextByFile(File file) throws Exception {
		StringBuilder sb = new StringBuilder();

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linha = "";
		while (true) {
			if (linha != null) {
				sb.append(linha);
			} else {
				break;
			}
			linha = reader.readLine();
		}
		reader.close();

		return sb.toString();
	}
}
