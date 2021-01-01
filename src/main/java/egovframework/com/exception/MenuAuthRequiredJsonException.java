package egovframework.com.exception;

import javax.servlet.ServletException;


/**
 * MenuAuthRequiredJsonException
 *
 * @author 
 * @since 1.0
 */
@SuppressWarnings("serial")
public class MenuAuthRequiredJsonException extends ServletException {

	/**
	 * Create a new SessionRequiredException.
	 * @param msg the detail message
	 */
	public MenuAuthRequiredJsonException(String msg) {
		super(msg);
	}
}
