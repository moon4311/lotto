package lotto.sas.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.impl.EgovComAbstractDAO;
import lotto.sas.service.StatisticAnalysVO;

@Repository("statisticAnalysDAO")
public class StatisticAnalysDAO extends EgovComAbstractDAO {

	public List<?> selectList(StatisticAnalysVO cmtSearchVO) {
		return selectList("statisticAnalys.selectList", cmtSearchVO);
	}

	public int selectListCnt(StatisticAnalysVO cmtManageVO) {
		return (int) selectOne("cmtManageDAO.selectListCnt", cmtManageVO);
	}

	public StatisticAnalysVO select(StatisticAnalysVO cmtManageVO) {
		return (StatisticAnalysVO) selectOne("cmtManageDAO.select", cmtManageVO);
	}

}