package pl.kurs.spring.bean.impl;

import pl.kurs.spring.bean.PrinterBean;

public class ConsolePrinterBean implements PrinterBean {

	@Override
	public void printText(String txt) {
		System.out.println("=== uruchamiam console printer ===");
		System.out.println(txt);
	}

}
