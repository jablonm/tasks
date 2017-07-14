package pl.kurs.spring.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.kurs.spring.bean.PrinterBean;
import pl.kurs.spring.bean.impl.ConsolePrinterBean;
import pl.kurs.spring.config.PrinterApplicationConfiguration;

public class Main {
	
	
	public static void main(String[] args) {
//		PrinterBean printer = new ConsolePrinterBean();
//		printer.printText("Hello (without spring)");
//		
//		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrinterApplicationConfiguration.class);
//		System.out.println("---- koniec budowania kontenera");
//		
//		PrinterBean logs = context.getBean("anotherTextFilePrinterBean", PrinterBean.class);
//		PrinterBean logs1 = context.getBean("anotherTextFilePrinterBean", PrinterBean.class);
//		
//		System.out.println("Czy to ta sama referencja: "+(logs==logs1));
//		
//		context.close();
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrinterApplicationConfiguration.class);
		context.getBean(PrinteRunner.class).run();
		context.close();
		
		
		
	}
}
