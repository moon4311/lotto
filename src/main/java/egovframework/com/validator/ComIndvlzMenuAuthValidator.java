package egovframework.com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import egovframework.com.vo.ComIndvlzMenuAuthVO;

/**
 * @Class Name : ComIndvlzMenuAuthValidator.java
 * @Description : 사용자별메뉴관리 validator
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by KMK All right reserved.
 */
@Component("comIndvlzMenuAuthValidator")
@SuppressWarnings("unused")
public class ComIndvlzMenuAuthValidator extends AbstractValidator implements Validator {
	//validate체크할  field들

	private static final String FIELDNAME_PRFIX = "job.cm.item.userMenuAuth";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return ComIndvlzMenuAuthVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final ComIndvlzMenuAuthVO command = (ComIndvlzMenuAuthVO) obj;
	}

}
