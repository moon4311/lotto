package egovframework.com.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.com.enums.EnumMenuCode;
import egovframework.com.exception.ValidatorException;
import egovframework.com.service.ComAuthGrpService;
import egovframework.com.service.ComIndvlzMenuAuthService;
import egovframework.com.service.ComMbrService;
import egovframework.com.service.ComMenuService;
import egovframework.com.util.NullUtil;
import egovframework.com.validator.ComIndvlzMenuAuthValidator;
import egovframework.com.vo.ComAuthGrpVO;
import egovframework.com.vo.ComIndvlzMenuAuthVO;
import egovframework.com.vo.ComMbrVO;
import egovframework.com.vo.ComMenuVO;


/**
 * @Class Name : ComIndvlzMenuAuthController.java
 * @Description : 사용자별메뉴관리 Controller
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by KMK All right reserved.
 */
@Controller
public class ComIndvlzMenuAuthController extends AbstractController{

	protected String getPkg(){return "egovframework/com/indvlzMenuAuth";}
	
	@Resource(name = "comMenuService")
	private ComMenuService comMenuService;
	
	@Resource(name = "comIndvlzMenuAuthService")
	private ComIndvlzMenuAuthService comIndvlzMenuAuthService;
	
	@Resource(name = "comIndvlzMenuAuthValidator")
	private ComIndvlzMenuAuthValidator comIndvlzMenuAuthValidator;
	
	@Resource(name = "comMbrService")
	private ComMbrService comMbrService;
	
	@Resource(name = "comAuthGrpService")
	private ComAuthGrpService comAuthGrpService;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/egovframework/com/indvlzMenuAuth/index.do")
	public String indexLarge(
			@ModelAttribute	ComIndvlzMenuAuthVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getCmumaMode())))searchVO.setCmumaMode("list");//기본 list로 포워딩		
		setIndexProcess(EnumMenuCode.COM_USER_MENU_AUTH, request, searchVO.getCmumaMode());//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/egovframework/com/indvlzMenuAuth/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/egovframework/com/indvlzMenuAuth/" + searchVO.getCmumaMode() + ".do");
		
		return sb.toString();
	}



	/**
	 * 리스트
	 */
	@RequestMapping(value="/egovframework/com/indvlzMenuAuth/list.do")
	public String list(
			@ModelAttribute("searchVO") ComIndvlzMenuAuthVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		//그룹리스트
		ComAuthGrpVO groupVO = new ComAuthGrpVO();
		groupVO.setRecordCountPerPage(0);
		groupVO.setSearchCondition("1");
		model.addAttribute("groupList",comAuthGrpService.selectComAuthGrpList(groupVO));
		
		//사용자리스트
		ComMbrVO userVO = new ComMbrVO();
		userVO.setRecordCountPerPage(0);
		userVO.setSearchCondition("1");
		userVO.setSearchKeyword(request.getParameter("searchKeyword"));
		model.addAttribute("userList",comMbrService.selectComMbrList(userVO));
		
		ComMenuVO menuVO = new ComMenuVO();
		menuVO.setRecordCountPerPage(0);
		model.addAttribute("menuList",comMenuService.selectMenuList(menuVO));
		
		
		return "egovframework/com/indvlzMenuAuth/list";
	}

	/**
	 * 뷰 Json
	 */
	@RequestMapping(value="/egovframework/com/indvlzMenuAuth/viewJson.do")
	public String viewJson(
			ComIndvlzMenuAuthVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		if("".equals(NullUtil.nullString(searchVO.getMbrId()))){
			searchVO.setMbrId("===========");
		}
		searchVO.setRecordCountPerPage(0);
		return getResponseJsonView(model, comIndvlzMenuAuthService.selectIndvlzMenuAuthList(searchVO));
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/egovframework/com/indvlzMenuAuth/deleteActionJson.do")
	public String deleteActionJson(
			ComIndvlzMenuAuthVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			
			comIndvlzMenuAuthService.deleteIndvlzMenuAuth(searchVO);
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		return getResponseJsonView(model, isSuccess, msg);
	}





	/**
	 * 추가 / 수정
	 */
	@RequestMapping(value="/egovframework/com/indvlzMenuAuth/write.do")
	public String write(
			ComIndvlzMenuAuthVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getMbrId()))){
			ComIndvlzMenuAuthVO result = comIndvlzMenuAuthService.selectIndvlzMenuAuth(searchVO);
			model.addAttribute("result",result);
		}
		
		return "egovframework/com/indvlzMenuAuth/write";
	}
	

	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/egovframework/com/indvlzMenuAuth/writeActionJson.do")
	public String writeActionJson(
			ComIndvlzMenuAuthVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);		
		

		boolean isSuccess = false;
		String msg = "";
		try{
			comIndvlzMenuAuthValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						

			List<ComIndvlzMenuAuthVO> authList = new ArrayList<ComIndvlzMenuAuthVO>();
			
			ComMenuVO menuVO = new ComMenuVO();
			menuVO.setRecordCountPerPage(0);
			List<ComMenuVO> menuList = comMenuService.selectMenuList(menuVO);
			if(menuList != null){
				for(ComMenuVO menu:menuList){
					String pre = menu.getMenuSno() + "_";
					String cmumaStoreAuth = NullUtil.nullString(request.getParameter(pre+"cmumaStrore"));
					String cmumaReadAuth = NullUtil.nullString(request.getParameter(pre+"cmumaRead"));
					String cmumaDeleteAuth = NullUtil.nullString(request.getParameter(pre+"cmumaDelete"));
					String cmumaPrintAuth = NullUtil.nullString(request.getParameter(pre+"cmumaPrint"));
					if(!"".equals(cmumaStoreAuth) || !"".equals(cmumaReadAuth) || !"".equals(cmumaDeleteAuth) || !"".equals(cmumaPrintAuth)){
						ComIndvlzMenuAuthVO authVO = new ComIndvlzMenuAuthVO();
						authVO.setMenuSno(menu.getMenuSno());
						authVO.setStreAuthYn(cmumaStoreAuth);
						authVO.setRedngAuthYn(cmumaReadAuth);
						authVO.setDelAuthYn(cmumaDeleteAuth);
						authVO.setPrntgAuthYn(cmumaPrintAuth);
						authList.add(authVO);
					}
				}
			}
			searchVO.setAuthList(authList);
			
			comIndvlzMenuAuthService.writeIndvlzMenuAuth(searchVO);
			
			isSuccess = true;
		}catch(ValidatorException e){
			return getResponseValidatorErrorJsonView(model, errors);
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		return getResponseJsonView(model, isSuccess, msg);
	}
	
	
}
