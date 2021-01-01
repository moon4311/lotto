package egovframework.com.cron;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import egovframework.com.service.ComCacheService;

/**
 *  관련 공통 cron
 * 
 * @author
 *
 */
@SuppressWarnings("unused")
@Component
public class ComCron {
	private final Log log = LogFactory.getLog(getClass());
	
	private final boolean isReal = false;//크론 실행시간 조정용(로컬에서는 자주 실행해 보기위해) 

	@Resource(name = "comCacheService")
	private ComCacheService comCacheService;
	
	/**
	 * 코드 캐시값 리로드(1시간에 1번)
	 * @throws Exception
	 */
	@Scheduled(cron = (isReal)?"0 0 * * * ?":"0 * * * * ?")
	public void codeReload() throws Exception{
		comCacheService.reloadIndvlzList();
	}
}
