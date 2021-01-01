package lotto.sas.service;

import java.util.List;


public interface StatisticAnalysService {

	public List<?> selectList(StatisticAnalysVO cmtSearchVO) throws Exception;

	public int selectListCnt(StatisticAnalysVO cmtSearchVO) throws Exception;

	public StatisticAnalysVO select(StatisticAnalysVO cmtSearchVO) throws Exception;
}