package in.co.rays.proj0.exception;

/**
 * ApplicationException is propogated from Service classes when an business
 * logic exception occurered.
 * 
 * @author Strategy
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
     * @param msg
     * Error message
     */
    public ApplicationException(String msg) {
        super(msg);
    }
}