package egovframework.com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.util.NullUtil;
import egovframework.com.util.PatternUtil;
import egovframework.com.vo.ComMbrVO;

/**
 * @Class Name : ComLoginPwChangeValidator.java
 * @Description : 로그인 비밀번호 변경 Validator
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by NCMS All right reserved.
 */
@Component("comLoginPwChangeValidator")
public class ComLoginPwChangeValidator extends AbstractValidator implements Validator {
	//validate체크할  field들
	private static final String mbrId = "mbrId";
	private static final String pswd = "pswd";
	

	private static final String FIELDNAME_PRFIX = "com.item.login";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return ComMbrVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final ComMbrVO command = (ComMbrVO) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mbrId, REQUIRED_FIELD, makeMessage(mbrId, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pswd, REQUIRED_FIELD, makeMessage(pswd, REQUIRED_FIELD));
			
		//패스워드 패턴 체크
		if(!NullUtil.nullString(command.getPswd()).equals("")){
			if(!PatternUtil.pwdRegularExpressionChk(command.getPswd()))errors.rejectValue(pswd, "com.error.login.pwpattern", getMessage("com.error.login.pwpattern"));
			if(PatternUtil.sameId(command.getPswd(), command.getMbrId()))errors.rejectValue(pswd, "com.error.login.pwsameid", getMessage("com.error.login.pwsameid"));
		} 
		
	}

}
