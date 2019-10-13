package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	
	private String fileName = "log.txt";
	private File logFile = new File(fileName);

	public Logger() {
		createNewFile();
	}

	private void createNewFile() {
		try {
			logFile.createNewFile();
		} catch (IOException e) {
		}
	}

	private String getCurrentTime() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime currentTime = LocalDateTime.now();
		   return dtf.format(currentTime);
	}

	public String logEvent(String event, String balanceBeforeTransaction, String afterTransaction) {
		String logString = String.format("%-24s %-22s %-14s %-14s", getCurrentTime(), event, balanceBeforeTransaction,
				afterTransaction);

		try (Writer fileWriter = new FileWriter(logFile, true);
				BufferedWriter buffered = new BufferedWriter(fileWriter)) {
			buffered.write(logString + "\n");
		} catch (IOException e1) {
		}
		return logString;


	}
}
