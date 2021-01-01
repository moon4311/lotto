package lotto.ognl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import lotto.ognl.service.OriginalService;
import lotto.ognl.service.OriginalVO;

/**
 * 출퇴근관리에 관한 비지니스 클래스를 정의한다.
 * @author 표준프레임워크 개발팀
 * @since 2009.04.10
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.10  개발팀          최초 생성
 *
 * </pre>
 */
@Service("cmtManageService")
public class OriginalServiceImpl extends EgovAbstractServiceImpl implements OriginalService {

	/** cmtManageDAO */
	@Resource(name = "originalDAO")
	private OriginalDAO dao;


	public List<?> selectList(OriginalVO vo) throws Exception{
		
		return dao.selectList(vo);
	}

	public int selectListCnt(OriginalVO vo) throws Exception{
		
		return dao.selectListCnt(vo);
	}

	public OriginalVO select(OriginalVO vo) throws Exception{
		return dao.select(vo);
	}

}