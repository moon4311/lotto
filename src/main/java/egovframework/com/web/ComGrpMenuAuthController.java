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
import egovframework.com.service.ComGrpMenuAuthService;
import egovframework.com.service.ComMenuService;
import egovframework.com.util.NullUtil;
import egovframework.com.validator.ComGrpMenuAuthValidator;
import egovframework.com.vo.ComAuthGrpVO;
import egovframework.com.vo.ComGrpMenuAuthVO;
import egovframework.com.vo.ComMenuVO;


/**
 * @Class Name : ComGrpMenuAuthController.java
 * @Description : 그룹별메뉴관리 Controller
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by KMK All right reserved.
 */
@Controller
public class ComGrpMenuAuthController extends AbstractController{

	protected String getPkg(){return "egovframework/com/grpMenuAuth";}
	
	@Resource(name = "comMenuService")
	private ComMenuService comMenuService;
	
	@Resource(name = "comGrpMenuAuthService")
	private ComGrpMenuAuthService comGrpMenuAuthService;
	
	@Resource(name = "comGrpMenuAuthValidator")
	private ComGrpMenuAuthValidator comGrpMenuAuthValidator;
	
	@Resource(name = "comAuthGrpService")
	private ComAuthGrpService comAuthGrpService;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/egovframework/com/grpMenuAuth/index.do")
	public String indexLarge(
			@ModelAttribute	ComGrpMenuAuthVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getCmgmaMode())))searchVO.setCmgmaMode("list");//기본 list로 포워딩		
		setIndexProcess(EnumMenuCode.COM_GROUP_MENU_AUTH, request, searchVO.getCmgmaMode());//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/egovframework/com/grpMenuAuth/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/egovframework/com/grpMenuAuth/" + searchVO.getCmgmaMode() + ".do");
		
		return sb.toString();
	}



	/**
	 * 리스트
	 */
	@RequestMapping(value="/egovframework/com/grpMenuAuth/list.do")
	public String list(
			@ModelAttribute("searchVO") ComGrpMenuAuthVO searchVO,
			@ModelAttribute("groupVO") ComAuthGrpVO groupVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//그룹리스트
		groupVO.setRecordCountPerPage(0);
		groupVO.setSearchCondition("1");
		model.addAttribute("groupList",comAuthGrpService.selectComAuthGrpList(groupVO));
		
		
		ComMenuVO menuVO = new ComMenuVO();
		menuVO.setRecordCountPerPage(0);
		model.addAttribute("menuList",comMenuService.selectMenuList(menuVO));
		
		
		return "egovframework/com/grpMenuAuth/list";
	}

	/**
	 * 뷰 Json
	 */
	@RequestMapping(value="/egovframework/com/grpMenuAuth/viewJson.do")
	public String viewJson(
			ComGrpMenuAuthVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		if("".equals(NullUtil.nullString(searchVO.getAuthGrpId()))){
			searchVO.setAuthGrpId("=============");
		}
		searchVO.setRecordCountPerPage(0);
//				model.addAttribute("resultList",comGrpMenuAuthService.selectGrpMenuAuthList(searchVO));
				
		return getResponseJsonView(model, comGrpMenuAuthService.selectGrpMenuAuthList(searchVO));
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/egovframework/com/grpMenuAuth/deleteActionJson.do")
	public String deleteActionJson(
			ComGrpMenuAuthVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			
			comGrpMenuAuthService.deleteGrpMenuAuth(searchVO);
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
	@RequestMapping(value="/egovframework/com/grpMenuAuth/write.do")
	public String write(
			ComGrpMenuAuthVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getMenuSno()))){
			ComGrpMenuAuthVO result = comGrpMenuAuthService.selectGrpMenuAuth(searchVO);
			model.addAttribute("result",result);
		}
		
		return "egovframework/com/grpMenuAuth/write";
	}
	

	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/egovframework/com/grpMenuAuth/writeActionJson.do")
	public String writeActionJson(
			ComGrpMenuAuthVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);		
		

		boolean isSuccess = false;
		String msg = "";
		try{
			comGrpMenuAuthValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			List<ComGrpMenuAuthVO> authList = new ArrayList<ComGrpMenuAuthVO>();
			
			ComMenuVO menuVO = new ComMenuVO();
			menuVO.setRecordCountPerPage(0);
			List<ComMenuVO> menuList = comMenuService.selectMenuList(menuVO);
			if(menuList != null){
				for(ComMenuVO menu:menuList){
					String pre = menu.getMenuSno() + "_";
					String redngAuthYn = NullUtil.nullString(request.getParameter(pre+"redngAuthYn"));
					String streAuthYn = NullUtil.nullString(request.getParameter(pre+"streAuthYn"));
					String delAuthYn = NullUtil.nullString(request.getParameter(pre+"delAuthYn"));
					String prntgAuthYn = NullUtil.nullString(request.getParameter(pre+"prntgAuthYn"));
					if(!"".equals(redngAuthYn) || !"".equals(streAuthYn) || !"".equals(delAuthYn) || !"".equals(prntgAuthYn)){
						ComGrpMenuAuthVO authVO = new ComGrpMenuAuthVO();
						authVO.setMenuSno(menu.getMenuSno());
						authVO.setStreAuthYn(streAuthYn);
						authVO.setRedngAuthYn(redngAuthYn);
						authVO.setDelAuthYn(delAuthYn);
						authVO.setPrntgAuthYn(prntgAuthYn);
						authList.add(authVO);
					}
				}
			}
			searchVO.setAuthList(authList);
			comGrpMenuAuthService.writeGrpMenuAuth(searchVO);
			
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
