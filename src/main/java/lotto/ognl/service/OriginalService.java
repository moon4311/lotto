package lotto.ognl.service;

import java.util.List;

public interface OriginalService {

	public List<?> selectList(OriginalVO originalVO) throws Exception;

	public int selectListCnt(OriginalVO originalVO) throws Exception;

	public OriginalVO select(OriginalVO originalVO) throws Exception;

}