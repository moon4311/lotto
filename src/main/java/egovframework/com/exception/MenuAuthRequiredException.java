package egovframework.com.exception;

import javax.servlet.ServletException;


/**
 * MenuAuthRequiredException
 *
 * @author 
 * @since 1.0
 */
@SuppressWarnings("serial")
public class MenuAuthRequiredException extends ServletException {

	/**
	 * Create a new SessionRequiredException.
	 * @param msg the detail message
	 */
	public MenuAuthRequiredException(String msg) {
		super(msg);
	}
}
