package lotto.ognl.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;
import lotto.ognl.service.OriginalService;

@Controller
public class OriginalController {

    @Resource(name = "originalService")
    private OriginalService originaleService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
	 * 권한 목록화면 이동
	 * @return String
	 * @exception Exception
	 */
    @RequestMapping("/sec/drm/EgovDeptAuthorListView.do")
    public String selectDeptAuthorListView() throws Exception {
        return "egovframework/com/sec/drm/EgovDeptAuthorManage";
    }    

	/**
	 * 부서별 할당된 권한목록 조회
	 * 
	 * @param deptAuthorVO DeptAuthorVO
	 * @param authorManageVO AuthorManageVO
	 * @return String
	 * @exception Exception
	 */
    @RequestMapping(value="/sec/drm/EgovDeptAuthorList.do")
	public String selectDeptAuthorList(
//			@ModelAttribute("deptAuthorVO") DeptAuthorVO deptAuthorVO,
//            @ModelAttribute("authorManageVO") AuthorManageVO authorManageVO,
			                             ModelMap model) throws Exception {
    	return null;
	}
}