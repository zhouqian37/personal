package cn.orange.service.excep;

public class UserAreadyExistException extends RuntimeException {
	private static final long serialVersionUID = -102196093565551623L;

	public UserAreadyExistException() {
		super();
	}

	public UserAreadyExistException(String message) {
		super(message);
	}
	
}
