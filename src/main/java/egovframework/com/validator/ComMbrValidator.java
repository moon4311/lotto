package egovframework.com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.util.NullUtil;
import egovframework.com.util.PatternUtil;
import egovframework.com.vo.ComMbrVO;

/**
 * @Class Name : ComMbrValidator.java
 * @Description : 회원 Validator
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Component("comMbrValidator")
public class ComMbrValidator extends AbstractValidator implements Validator {
	//validate체크할  field들
	private static final String mbrId = "mbrId";
	private static final String pswd = "pswd";
	private static final String mbrNm = "mbrNm";
	private static final String authGrpId = "authGrpId";
	private static final String uprPsitnCd = "uprPsitnCd";
	private static final String psitnCd = "psitnCd";
	private static final String mbrIpAddr = "mbrIpAddr";
	private static final String pstnNm = "pstnNm";
	private static final String deptNm = "deptNm";
	private static final String confmYn = "confmYn";
	private static final String confmBgnDate = "confmBgnDate";
	private static final String confmEndDate = "confmEndDate";
	private static final String telno = "telno";
	private static final String faxno = "faxno";
	private static final String sidoCd = "sidoCd";
	private static final String sigunGuCd = "sigunGuCd";
	private static final String email = "email";
	private static final String drmExcelAuthVl = "drmExcelAuthVl";
	private static final String pswdChngDt = "pswdChngDt";
	private static final String pswdChngCyclVl = "pswdChngCyclVl";
	private static final String loginFailrNmb = "loginFailrNmb";
	private static final String crtfctInfoCnts = "crtfctInfoCnts";
	

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
		//추가시
		if(!"Y".equals(command.getNotmbrId())) {
			//ID패턴체크
			if(!NullUtil.nullString(command.getMbrId()).equals("") && !PatternUtil.idRegularExpressionChk(command.getMbrId()))errors.rejectValue(mbrId, "com.error.login.idpattern", getMessage("com.error.login.idpattern"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,pswd, REQUIRED_FIELD, makeMessage(pswd, REQUIRED_FIELD));
		}
		//패스워드 패턴 체크
		if(!NullUtil.nullString(command.getPswd()).equals("") && !PatternUtil.pwdRegularExpressionChk(command.getPswd()))errors.rejectValue(pswd, "com.error.login.pwpattern", getMessage("com.error.login.pwpattern"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mbrNm, REQUIRED_FIELD, makeMessage(mbrNm, REQUIRED_FIELD));
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,uprPsitnCd, REQUIRED_SELECT_FIELD, makeMessage(uprPsitnCd, REQUIRED_SELECT_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,, REQUIRED_FIELD, makeMessage(psitnCd, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mbrIpAddr, REQUIRED_FIELD, makeMessage(mbrIpAddr, REQUIRED_FIELD));
		System.out.println("IP"+command.getMbrIpAddr());
		if(!NullUtil.nullString(command.getMbrIpAddr()).equals("") && !PatternUtil.isIp(command.getMbrIpAddr()))errors.rejectValue(mbrId, "com.error.login.ippattern", getMessage("com.error.login.ippattern"));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pstnNm, REQUIRED_FIELD, makeMessage(pstnNm, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,deptNm, REQUIRED_FIELD, makeMessage(deptNm, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,confmYn, REQUIRED_FIELD, makeMessage(confmYn, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,authGrpId, REQUIRED_FIELD, makeMessage(authGrpId, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,confmBgnDate, REQUIRED_FIELD, makeMessage(confmBgnDate, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,confmEndDate, REQUIRED_FIELD, makeMessage(confmEndDate, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,telno, REQUIRED_FIELD, makeMessage(telno, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,faxno, REQUIRED_FIELD, makeMessage(faxno, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sidoCd, REQUIRED_FIELD, makeMessage(sidoCd, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sigunGuCd, REQUIRED_FIELD, makeMessage(sigunGuCd, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,email, REQUIRED_FIELD, makeMessage(email, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,drmExcelAuthVl, REQUIRED_FIELD, makeMessage(drmExcelAuthVl, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pswdChngDt, REQUIRED_FIELD, makeMessage(pswdChngDt, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pswdChngCyclVl, REQUIRED_FIELD, makeMessage(pswdChngCyclVl, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,loginFailrNmb, REQUIRED_FIELD, makeMessage(loginFailrNmb, REQUIRED_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,crtfctInfoCnts, REQUIRED_FIELD, makeMessage(crtfctInfoCnts, REQUIRED_FIELD));
		
	}

}
