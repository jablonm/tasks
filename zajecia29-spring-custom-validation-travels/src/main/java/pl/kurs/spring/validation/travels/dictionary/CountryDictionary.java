package pl.kurs.spring.validation.travels.dictionary;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CountryDictionary implements HardcodeDictionary {

	@Override
	public List<String> values() {
		return Arrays.asList("Polska", "Chiny", "Niemcy");
	}

	@Override
	public String getName() {
		return "countries";
	}

}
