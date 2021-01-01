package lotto.sas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import lotto.sas.service.StatisticAnalysService;
import lotto.sas.service.StatisticAnalysVO;


@Service("statisticAnalysService")
public class StatisticAnalysServiceImpl extends EgovAbstractServiceImpl implements StatisticAnalysService{

	/** cmtManageDAO */
	@Resource(name = "statisticAnalysDAO")
	private StatisticAnalysDAO dao;


	public List<?> selectList(StatisticAnalysVO vo) throws Exception{
		
		return dao.selectList(vo);
	}

	public int selectListCnt(StatisticAnalysVO vo) throws Exception{
		
		return dao.selectListCnt(vo);
	}

	public StatisticAnalysVO select(StatisticAnalysVO vo) throws Exception{
		return dao.select(vo);
	}

}