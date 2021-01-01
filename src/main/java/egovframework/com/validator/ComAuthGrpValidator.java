package egovframework.com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.vo.ComAuthGrpVO;

/**
 * @Class Name : ComAuthGrpValidator.java
 * @Description : 그룹 Validator
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("comAuthGrpValidator")
public class ComAuthGrpValidator extends AbstractValidator implements Validator {
	//validate체크할  field들
	private static final String authGrpId = "authGrpId";
	private static final String grpNm = "grpNm";
	private static final String grpExplnt = "grpExplnt";
	private static final String useYn = "useYn";

	private static final String FIELDNAME_PRFIX = "com.item.AuthGrp";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return ComAuthGrpVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final ComAuthGrpVO command = (ComAuthGrpVO) obj;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,authGrpId, REQUIRED_FIELD, makeMessage(authGrpId, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,grpNm, REQUIRED_FIELD, makeMessage(grpNm, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,grpExplnt, REQUIRED_FIELD, makeMessage(grpExplnt, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,useYn, REQUIRED_FIELD, makeMessage(useYn, REQUIRED_FIELD));
	}

}
