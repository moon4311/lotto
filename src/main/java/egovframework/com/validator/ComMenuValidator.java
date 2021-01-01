package egovframework.com.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.vo.ComLoginMenuVO;
import egovframework.com.vo.ComMenuVO;

/**
 * @Class Name : ComMenuValidator.java
 * @Description : 메뉴 validator
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by KMK All right reserved.
 */
@Component("comMenuValidator")
@SuppressWarnings("unused")
public class ComMenuValidator extends AbstractValidator implements Validator {
	//validate체크할  field들
	private static final String menuSno = "menuSno";
	private static final String menuNm = "menuNm";
	private static final String menuUrl = "menuUrl";
	private static final String uprMenuSno = "uprMenuSno";
	private static final String menuSeq = "menuSeq";
	private static final String menuLvlVl = "menuLvlVl";

	private static final String FIELDNAME_PRFIX = "com.item.menu";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return ComLoginMenuVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final ComMenuVO command = (ComMenuVO) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,menuNm, REQUIRED_FIELD, makeMessage(menuNm, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,menuUrl, REQUIRED_FIELD, makeMessage(menuUrl, REQUIRED_FIELD));
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,menuSeq, REQUIRED_FIELD, makeMessage(menuSeq, REQUIRED_FIELD));
		if(!StringUtils.isNumeric(command.getMenuSeq()))errors.rejectValue(menuSeq, INVALID_NUMBER_FIELD, makeMessage(menuSeq, INVALID_NUMBER_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,menuLvlVl, REQUIRED_FIELD, makeMessage(menuLvlVl, REQUIRED_FIELD));
//		if(!StringUtils.isNumeric(command.getMenuLvlVl()))errors.rejectValue(menuLvlVl, INVALID_NUMBER_FIELD, makeMessage(menuLvlVl, INVALID_NUMBER_FIELD));
		
		
		
	}

}
