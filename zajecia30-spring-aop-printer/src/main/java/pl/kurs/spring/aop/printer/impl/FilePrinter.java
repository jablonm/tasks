package pl.kurs.spring.aop.printer.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;

import pl.kurs.spring.aop.printer.annotation.NotNullText;

public class FilePrinter implements PrinterBean {

	private String file;

	public FilePrinter(String file) {
		this.file = file;
	}

	@NotNullText
	public void print(String txt) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
			out.write(txt);
			out.newLine();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
