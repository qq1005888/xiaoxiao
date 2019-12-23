package cn.tedu.store.util;

/**
 * 用于封装返回给客户端数据的类
 * @author JAVA
 *
 * @param <T>
 */
//@JsonInclude(Include.NON_NULL)  //加此注解就是让为null的属性隐藏起来
public class JsonResult<T> {
	
	private Integer state;
	private String message;
	private  T data;
	public JsonResult(Throwable e) {
		super();
		this.message = e.getMessage();
	}
	public JsonResult() {
		super();
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public JsonResult(Integer state) {
		super();
		this.state = state;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	//构造
	public JsonResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}
	

}
