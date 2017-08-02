package pl.kurs.spring.validation.employee.valid;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselValueValidator implements ConstraintValidator<Pesel, String> {

	@Override
	public void initialize(Pesel arg0) {

	}

	@Override
	public boolean isValid(String pesel, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile("(\\d{11})");
		if (!pattern.matcher(pesel).matches()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Pesel musi zawierac 11 cyfr").addConstraintViolation();
			return false;
		}

		if (!checkSumControll(pesel)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Nie zgadza sie suma kontrolna").addConstraintViolation();
			return false;
		}

		if (!checkDate(pesel)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Nieprawidłowa data w Pesel").addConstraintViolation();
			return false;
		}

		return true;
	}

	private static boolean checkDate(String pesel) {

		String yearPrefix = pesel.charAt(2) == '0' || pesel.charAt(2) == '1' ? "19" : "20";
		String month = Integer.parseInt(pesel.substring(2, 4)) < 13 ? pesel.substring(2, 4) : String.valueOf(Integer.parseInt(pesel.substring(2, 4)) - 20);
		String dateStr = yearPrefix + pesel.substring(0, 2) + "-" + month + "-" + pesel.substring(4, 6);
		//dateStr za pomoca np: simpledateFormatter przeksztalcasz na date, lub przy pomocy Calendar i metod .set(co, wartosc)
		//czy data stworzona w kalendarzu jest taka sama jak podana w numerze pesel:
		//897090
		//2089-50-90 -> 2093-06-30

		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Integer.parseInt(yearPrefix + pesel.substring(0, 2)), Integer.parseInt(month)-1, Integer.parseInt(pesel.substring(4, 6)));
		if (!dateStr.equals(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH))) {
			return false;
		}
		return true;

	}
	
	private static boolean checkSumControll(String pesel) {
		int digits[] = new int[10];
		int weight[] = { 9, 7, 3, 1, 9, 7, 3, 1, 9, 7 };

		for (int i = 0; i < pesel.length() - 1; i++) {
			digits[i] = pesel.charAt(i) - '0';
		}

		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum += digits[i] * weight[i];
		}

		if (!((pesel.charAt(pesel.length() - 1) - '0') == sum % 10)) {
			return false;
		}

		return true;
	}

}
