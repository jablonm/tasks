package main.service.impl;

import java.util.ArrayList;
import java.util.List;

import main.model.Client;
import main.model.valid.ValidationError;
import main.model.valid.ValidatiorResult;
import main.service.ValidationService;

public class ClientValidationService implements ValidationService<Client> {

	@Override
	public ValidatiorResult validate(Client obj) {
		List<ValidationError> errors = new ArrayList<>();
		if (obj.getName() == null || obj.getName().isEmpty()) {
			errors.add(new ValidationError("name", "Imie nie moze byc puste"));
		}

		return new ValidatiorResult(errors.isEmpty(), errors);
	}

}
