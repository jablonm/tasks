package pl.kurs.spring.aop.printer.impl;

import org.springframework.stereotype.Service;

@Service
public class ConsolePrinter implements PrinterBean {

	public void print(String txt) {
		System.out.println(txt);
	}

}
