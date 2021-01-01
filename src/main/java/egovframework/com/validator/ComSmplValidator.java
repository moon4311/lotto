package egovframework.com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.vo.ComSmplVO;

/**
 * @Class Name : ComSmplValidator.java
 * @Description : 샘플 Validator
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("comSmplValidator")
public class ComSmplValidator extends AbstractValidator implements Validator {
	//validate체크할  field들
	private static final String smplId = "smplId";
	private static final String smplNm = "smplNm";

	private static final String FIELDNAME_PRFIX = "com.item.smpl";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return ComSmplVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final ComSmplVO command = (ComSmplVO) obj;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,smplId, REQUIRED_FIELD, makeMessage(smplId, REQUIRED_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,smplNm, REQUIRED_FIELD, makeMessage(smplNm, REQUIRED_FIELD));
	}

}
