package lotto.sas.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import lotto.sas.service.StatisticAnalysService;
import lotto.sas.service.StatisticAnalysVO;

/**
 * 부서권한에 관한 controller 클래스를 정의한다.
 * @author 공통서비스 개발팀 이문준
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.11  이문준          최초 생성
 *   2011.8.26	정진오			IncludedInfo annotation 추가
 *
 * </pre>
 */


@Controller
public class StatisticAnalysController {

    
    @Resource(name = "statisticAnalysService")
    private StatisticAnalysService statisticAnalysService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;


    @RequestMapping(value="/sec/drm/EgovDeptAuthorList.do")
	public String selectDeptAuthorList(@ModelAttribute("staticAnalysVO") StatisticAnalysVO staticAnalysVO,
			                             ModelMap model) throws Exception {

    	/** paging */
    	PaginationInfo paginationInfo = new PaginationInfo();
        return "egovframework/com/sec/drm/EgovDeptAuthorManage";
	}
	
}