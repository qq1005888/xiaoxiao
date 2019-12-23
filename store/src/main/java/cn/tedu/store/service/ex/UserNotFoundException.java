package cn.tedu.store.service.ex;
/**
 * 用户名不存在的异常
 * @author JAVA
 *
 */
public class UserNotFoundException extends RuntimeException{

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 5156778717593377564L;

	public UserNotFoundException() {
		super();
		
	}

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UserNotFoundException(String message) {
		super(message);
		
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}

}
