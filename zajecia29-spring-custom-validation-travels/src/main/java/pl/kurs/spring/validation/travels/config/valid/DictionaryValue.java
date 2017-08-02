package pl.kurs.spring.validation.travels.config.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DictionaryValueValidator.class)
public @interface DictionaryValue {
	String dictionaryName();

	String message() default "wartosc spoza słownika";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
