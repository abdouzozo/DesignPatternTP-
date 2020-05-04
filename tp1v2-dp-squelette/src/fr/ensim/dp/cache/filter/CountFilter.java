package fr.ensim.dp.cache.filter;

import org.apache.log4j.Logger;

import fr.ensim.dp.util.LoggerUtil;

public class CountFilter extends AbstractFilterCache {
	
	private int countAdd;
	private int countRetrieve;
	
	private static Logger log = LoggerUtil.getLogger();
	
	public CountFilter() {
		this.countAdd = 0;	
		this.countRetrieve = 0;	
	}

	public int getCountAdd() {
		return countAdd;
	}
	public int getCountRetrieve() {
		return countRetrieve;
	}


	@Override
	public byte[] doAdd(String key, byte[] buf) {
	
		countAdd++;
		
		String strBuff = new String(buf);
		log.info("countFilter : >>doAdd key = " + key + " -- buf : "+ strBuff +" . ");
		log.info("countFilter : <<doAdd");
		
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
		countRetrieve++;
		
		String strBuff = new String(buf);
		log.info("countFilter : >>doRetreive key = " + key + " -- buf : "+ strBuff +" . ");
		log.info("countFilter : <<doRetreive");
		
		return buf;
	}


}
