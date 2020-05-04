package fr.ensim.dp.cache.filter;

import org.apache.log4j.Logger;
import fr.ensim.dp.util.LoggerUtil;

public class LogFilterCache extends AbstractFilterCache {
	
	private static Logger log = LoggerUtil.getLogger();
	
	
	
	@Override
	public byte[] doAdd(String key, byte[] buf) {

		String strBuff = new String(buf);
		log.info("logFilter : >>doAdd key = " + key + " -- buf : "+ strBuff +" . ");
		log.info("logFilter : <<doAdd");
		
		if(next!= null) {
			buf = next.doAdd(key, buf);
		}
		return buf;
	}
		

	@Override
	public byte[] doRetreive(String key, byte[] buf) {
		if(next!= null) {
			buf = next.doRetreive(key, buf);
		}
		
		String strBuff = new String(buf);
		log.info("logFilter : >>doRetreive key = " + key + " -- buf : "+ strBuff +" . ");
		log.info("logFilter : <<doRetreive");
		
		return buf;
	}


	
	

}
