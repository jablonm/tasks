package pl.kurs.spring.aop.printer.aspect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LogParameterdAspect {

	@PostConstruct
	private void init() {
		File logFile = new File("log.csv");
		if (!logFile.exists()) {
			try (BufferedWriter out = new BufferedWriter(new FileWriter(logFile, true))) {
				out.write("DATA;KLASA;METODA;ARGUMENTY");
				out.newLine();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	@Before("execution(* pl.kurs.spring.aop.printer.impl.*.print(..))")
	public void logParameters(JoinPoint joinPoint) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		String dateEvent = sdf.format(date);
		String classJP = joinPoint.getTarget().getClass().toString();
		String method = joinPoint.getSignature().toString();
		String args = Arrays.toString(joinPoint.getArgs());

		//System.out.println(dateEvent + ";" + classJP + ";" + method + ";" + args);
		addToLog(dateEvent + ";" + classJP + ";" + method + ";" + args);
	}

	public void addToLog(String event) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(event, true))) {
			out.write(event);
			out.newLine();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
