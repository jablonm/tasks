package pl.kurs.spring.validation.travels.dictionary;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RegionDictionary implements HardcodeDictionary {

	@Override
	public List<String> values() {
		return Arrays.asList("MORZE", "GORY", "LAS", "JEZIORO", "MIASTO");
	}

	@Override
	public String getName() {
		return "regions";
	}

}
