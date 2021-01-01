package egovframework.com.exception;

import javax.servlet.ServletException;


/**
 * SessionRequiredJsonException
 *
 * @author 
 * @since 1.0
 */
@SuppressWarnings("serial")
public class SessionRequiredJsonException extends ServletException {

	/**
	 * Create a new SessionRequiredException.
	 * @param msg the detail message
	 */
	public SessionRequiredJsonException(String msg) {
		super(msg);
	}
}
