package egovframework.com.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.com.enums.EnumMenuCode;
import egovframework.com.service.ComAuthGrpService;
import egovframework.com.service.ComGrpMenuAuthChngService;
import egovframework.com.util.NullUtil;
import egovframework.com.vo.ComAuthGrpVO;
import egovframework.com.vo.ComGrpMenuAuthChngVO;


/**
 * @Class Name : ComGrpMenuAuthChngController.java
 * @Description : 그룹메뉴권한변경이력 Controller
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class ComGrpMenuAuthChngController extends AbstractController{
	
	protected String getPkg(){return "egovframework/com/grpMenuAuthChng";}
	
	@Resource(name = "comGrpMenuAuthChngService")
	private ComGrpMenuAuthChngService comGrpMenuAuthChngService;

	@Resource(name = "comAuthGrpService")
	private ComAuthGrpService comAuthGrpService;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/egovframework/com/grpMenuAuthChng/index.do")
	public String index(
			@ModelAttribute	ComGrpMenuAuthChngVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getCgmcMode())))searchVO.setCgmcMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCode.COM_GROUP_MENU_HST, request, searchVO.getCgmcMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/egovframework/com/grpMenuAuthChng/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/egovframework/com/grpMenuAuthChng/" + searchVO.getCgmcMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/egovframework/com/grpMenuAuthChng/list.do")
	public String list(
			@ModelAttribute("searchVO")	ComGrpMenuAuthChngVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			model.addAttribute("resultList",comGrpMenuAuthChngService.selectComGrpMenuAuthChngList(searchVO));
			return getResponseExcelView(model, "grpMenuAuthChng", "그룹메뉴권한변경이력");
		}else {

			//그룹리스트
			ComAuthGrpVO groupVO = new ComAuthGrpVO();
			groupVO.setRecordCountPerPage(0);
			model.addAttribute("groupList",comAuthGrpService.selectComAuthGrpList(groupVO));
			
			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = comGrpMenuAuthChngService.selectComGrpMenuAuthChngTot(searchVO);

	    	PaginationInfo paginationInfo = new PaginationInfo();
			paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
			paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
			paginationInfo.setPageSize(searchVO.getPageSize());
	    	paginationInfo.setTotalRecordCount(totalRecordCount);
			
			searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
			searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
			searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
			
			//전체가져올때
			if(searchVO.getPageUnit() == -1)searchVO.setRecordCountPerPage(0);
			
			model.addAttribute("paginationInfo",paginationInfo);
			model.addAttribute("resultCnt",totalRecordCount);
			model.addAttribute("resultList",comGrpMenuAuthChngService.selectComGrpMenuAuthChngList(searchVO));
		}
		
		
		return "egovframework/com/grpMenuAuthChng/list";
	}

}
