package lotto.ognl.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.impl.EgovComAbstractDAO;
import lotto.ognl.service.OriginalVO;

/**
 * 출퇴근관리에 관한 데이터 접근 클래스를 정의한다.
 * @author 표준프레임워크 개발팀
 * @since 2014.11.10
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일         수정자           수정내용
 *  -------       ----------    ---------------------------
 *   2014.11.10   개발팀     최초 생성
 *
 * </pre>
 */
@Repository("originalDao")
public class OriginalDAO extends EgovComAbstractDAO {

	public List<?> selectList(OriginalVO originalVO) {
		return selectList("originalDao.selectList", originalVO);
	}

	public int selectListCnt(OriginalVO originalVO) {
		return (int) selectOne("originalDao.selectListCnt", originalVO);
	}

	public OriginalVO select(OriginalVO originalVO) {
		return (OriginalVO) selectOne("originalDao.select", originalVO);
	}

}