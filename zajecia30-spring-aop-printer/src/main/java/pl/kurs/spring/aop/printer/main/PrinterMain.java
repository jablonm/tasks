package pl.kurs.spring.aop.printer.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.kurs.spring.aop.printer.config.PrinterConfiguration;
import pl.kurs.spring.aop.printer.impl.PrinterBean;

public class PrinterMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrinterConfiguration.class);
		context.getBean("testFilePrinter",PrinterBean.class).print("test");
		context.getBean("prodFilePrinter",PrinterBean.class).print("prod");
		context.getBean("consolePrinter",PrinterBean.class).print("jakistekst");
		context.close();
	}
	
}
