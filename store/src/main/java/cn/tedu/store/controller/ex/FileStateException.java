package cn.tedu.store.controller.ex;

/**
 * 上传文件时，文件状态异常，可能是因为文件被移动，导致文件不可被访问
 */
public class FileStateException extends FileUploadException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7150153238399934786L;

	public FileStateException() {
		super();
	}

	public FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileStateException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileStateException(String message) {
		super(message);
	}

	public FileStateException(Throwable cause) {
		super(cause);
	}

}
