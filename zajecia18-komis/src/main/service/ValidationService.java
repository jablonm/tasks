package main.service;

import main.model.valid.ValidatiorResult;

public interface ValidationService<TYPE> {
	ValidatiorResult validate(TYPE obj);
}
