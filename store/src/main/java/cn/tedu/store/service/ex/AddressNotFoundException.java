package cn.tedu.store.service.ex;
/**
 * 业务异常的基类
 * @author JAVA
 *
 */
public class AddressNotFoundException extends ServiceException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4234461510773896049L;

	public AddressNotFoundException() {
		super();
		
	}

	public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AddressNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AddressNotFoundException(String message) {
		super(message);
		
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
	}

}
