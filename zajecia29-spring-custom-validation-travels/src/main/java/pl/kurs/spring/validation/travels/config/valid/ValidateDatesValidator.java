package pl.kurs.spring.validation.travels.config.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Service;

import pl.kurs.spring.validation.travels.config.model.DateFromDateTo;

@Service
public class ValidateDatesValidator implements ConstraintValidator<ValidateDates, DateFromDateTo> {
	private String message;
	private String errorProperty;

	@Override
	public void initialize(ValidateDates a) {
		this.message = a.message();
		this.errorProperty = a.errorProperty();
	}

	@Override
	public boolean isValid(DateFromDateTo arg0, ConstraintValidatorContext context) {
		boolean result = arg0.dateTo().after(arg0.dateFrom());
		if (!result) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)//
					.addPropertyNode(errorProperty)//
					.addConstraintViolation();//
		}
		return result;
	}

}
