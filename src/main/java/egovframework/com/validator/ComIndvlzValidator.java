package egovframework.com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.vo.ComIndvlzVO;

/**
 * @Class Name : ComIndvlzValidator.java
 * @Description : 개별코드 Validator
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("comIndvlzValidator")
public class ComIndvlzValidator extends AbstractValidator implements Validator {
	//validate체크할  field들
	private static final String indvlzId = "indvlzId";
	private static final String indvlzNm = "indvlzNm";

	private static final String FIELDNAME_PRFIX = "com.item.indvlz";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return ComIndvlzVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final ComIndvlzVO command = (ComIndvlzVO) obj;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,indvlzId, REQUIRED_FIELD, makeMessage(indvlzId, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,indvlzNm, REQUIRED_FIELD, makeMessage(indvlzNm, REQUIRED_FIELD));
	}

}
