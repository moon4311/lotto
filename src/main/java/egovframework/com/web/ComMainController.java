package egovframework.com.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.enums.EnumMenuCode;
import egovframework.com.service.ComCacheService;
import egovframework.com.service.ComMbrService;

/**
 *  메인페이지 클래스
 * @author 
 * @since 2020.10.07
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2020.10.07            최초 생성
 *
 * </pre>
 */
@Controller
public class ComMainController extends AbstractController{

	protected String getPkg(){return "egovframework/com/main";}

	@Resource(name = "comCacheService")
	private ComCacheService comCacheService;

	@Resource(name = "comMbrService")
	private ComMbrService comMbrService;

	
	/**
	 * 관리자 메인페이지
	 */
	@RequestMapping(value="/egovframework/com/main/index.do")
	public String index(
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		setIndexProcess(EnumMenuCode.MAIN, request, "main");
		
		
		
		return "egovframework/com/main/index";
	}
}
