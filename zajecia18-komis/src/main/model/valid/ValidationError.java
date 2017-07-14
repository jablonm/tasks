package main.model.valid;

public class ValidationError {
	private final String filed;
	private final String message;

	public ValidationError(String filed, String message) {
		this.filed = filed;
		this.message = message;
	}

	public String getFiled() {
		return filed;
	}

	public String getMessage() {
		return message;
	}

}
