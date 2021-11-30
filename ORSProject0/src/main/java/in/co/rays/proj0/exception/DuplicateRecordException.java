package in.co.rays.proj0.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * 
 * @author Strategy
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public class DuplicateRecordException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg
	 * Error message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}

}