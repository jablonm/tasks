package main.model.valid;

import java.util.HashMap;
import java.util.List;

public class ValidatiorResult extends HashMap<String, ValidationError>{
	private final boolean success;
	private final List<ValidationError> errors;

	public ValidatiorResult(boolean success, List<ValidationError> errors) {
		this.success = success;
		this.errors = errors;
	}

	public boolean isSuccess() {
		return success;
	}

	public List<ValidationError> getErrors() {
		return errors;
	}
	
	@Override
	public ValidationError get(Object key) {
		return errors.stream().filter(f-> f.getFiled().equals(key.toString())).findAny().orElse(null);
	}

}
