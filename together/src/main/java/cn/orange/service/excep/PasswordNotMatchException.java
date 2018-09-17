package cn.orange.service.excep;

public class PasswordNotMatchException extends RuntimeException {

	private static final long serialVersionUID = 6729731490033408313L;

	public PasswordNotMatchException() {
		super();
	}

	public PasswordNotMatchException(String message) {
		super(message);
	}
	
}
