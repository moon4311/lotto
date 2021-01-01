package egovframework.com.exception;

import javax.servlet.ServletException;


/**
 * SessionRequiredException
 *
 * @author 
 * @since 1.0
 */
@SuppressWarnings("serial")
public class SessionRequiredException extends ServletException {

	/**
	 * Create a new SessionRequiredException.
	 * @param msg the detail message
	 */
	public SessionRequiredException(String msg) {
		super(msg);
	}
}
