package pl.kurs.spring.validation.employee.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.kurs.spring.validation.employee.valid.PeselValueValidator;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PeselValueValidator.class)
public @interface Pesel {
	
	String message() default "Nieprawidlowy PESEL!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
