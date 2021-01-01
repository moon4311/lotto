package egovframework.com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.vo.ComGrpMenuAuthVO;

/**
 * @Class Name : ComGrpMenuAuthValidator.java
 * @Description : 그룹별메뉴관리 validator
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by KMK All right reserved.
 */
@Component("comGrpMenuAuthValidator")
@SuppressWarnings("unused")
public class ComGrpMenuAuthValidator extends AbstractValidator implements Validator {
	//validate체크할  field들
	private static final String authGrpId = "authGrpId";

	private static final String FIELDNAME_PRFIX = "com.item.grpMenuAuth";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return ComGrpMenuAuthVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final ComGrpMenuAuthVO command = (ComGrpMenuAuthVO) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,authGrpId, REQUIRED_SELECT_FIELD, makeMessage(authGrpId, REQUIRED_SELECT_FIELD));
	}

}
