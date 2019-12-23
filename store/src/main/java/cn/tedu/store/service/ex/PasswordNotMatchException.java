package cn.tedu.store.service.ex;
/**
 * 密码不匹配异常
 * @author JAVA
 *
 */
public class PasswordNotMatchException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1903639604855086304L;

	public PasswordNotMatchException() {
		super();
		
	}

	public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PasswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PasswordNotMatchException(String message) {
		super(message);
		
	}

	public PasswordNotMatchException(Throwable cause) {
		super(cause);
	}

}
