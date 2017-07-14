package pl.kurs.spring.bean.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.annotation.PostConstruct;

import pl.kurs.spring.bean.PrinterBean;

public class FilePrinterBean implements PrinterBean {

	private final File saveTo;
	
	public FilePrinterBean(File saveTo) {
		this.saveTo = saveTo;
	}

	@PostConstruct
	public void init() {
		System.out.println("=== TWORZE BEANA:" + getClass().getSimpleName());
	}

	@Override
	public void printText(String txt) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(saveTo, true))) {
			out.write(txt);
			out.newLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
