package pl.kurs.spring.validation.travels.config.valid;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kurs.spring.validation.travels.dictionary.HardcodeDictionary;

@Service
public class DictionaryValueValidator implements ConstraintValidator<DictionaryValue, String> {

	private List<String> values;

	@Autowired
	private Set<HardcodeDictionary> dictionaries;
	private Map<String, HardcodeDictionary> dictionariesMap;

	@PostConstruct
	public void init() {
		dictionariesMap = dictionaries.stream().collect(Collectors.toMap(HardcodeDictionary::getName, Function.identity()));
		System.out.println(dictionariesMap.keySet().toString());
	}

	@Override
	public void initialize(DictionaryValue arg0) {
		values = dictionariesMap.get(arg0.dictionaryName()).values();

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		System.out.println("Waliduje: " + value + ", dla: " + values);
		boolean wynik = values.contains(value);
		System.out.println("Wynik: " + wynik);
		return wynik;
	}

}
