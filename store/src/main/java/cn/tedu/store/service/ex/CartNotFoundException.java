package cn.tedu.store.service.ex;
/**
 * 用户名冲突的异常,例如:注册时，用户名应景被占用
 * @author JAVA
 *
 */
public class CartNotFoundException extends ServiceException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -290753401450618624L;

	public CartNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CartNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CartNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CartNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
