package cn.orange.service.excep;

public class UsernameNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6731338620392136474L;

	public UsernameNotFoundException() {
		super();
	}

	public UsernameNotFoundException(String message) {
		super(message);
	}
	
}
