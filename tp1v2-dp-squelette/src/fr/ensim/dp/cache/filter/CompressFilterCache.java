package fr.ensim.dp.cache.filter;

import java.io.IOException;

import org.apache.log4j.Logger;

import fr.ensim.dp.util.GzipUtil;
import fr.ensim.dp.util.LoggerUtil;

public class CompressFilterCache extends AbstractFilterCache {
	
	private static Logger log = LoggerUtil.getLogger();
	

	@Override
	public byte[] doAdd(String key, byte[] buf) {
		
		
		
		try {
			buf = GzipUtil.compress(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		String strBuff = new String(buf);
		log.info("compressFilter : >>doAdd key = " + key + " -- buf : "+ strBuff +" . ");
		log.info("compressFilter : <<doAdd");
		
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
		try {
			buf = GzipUtil.uncompress(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String strBuff = new String(buf);
		log.info("compressFilter : >>doRetreive key = " + key + " -- buf : "+ strBuff +" . ");
		log.info("compressFilter : <<doRetreive");
		
		return buf;
	}
	

}
