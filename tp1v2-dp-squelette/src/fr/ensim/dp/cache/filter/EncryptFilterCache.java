package fr.ensim.dp.cache.filter;

import org.apache.log4j.Logger;

import fr.ensim.dp.util.AES;
import fr.ensim.dp.util.LoggerUtil;

public class EncryptFilterCache extends AbstractFilterCache {
	
	private static Logger log = LoggerUtil.getLogger();
	
	final String secretKey = "ThisIsMySecretKey";
	
	@Override
	public byte[] doAdd(String key, byte[] buf) {
		
		buf = AES.encrypt(buf, secretKey);

		String strBuff = new String(buf);
		log.info("encryptFilter : >>doAdd key = " + key + " -- buf : "+ strBuff +" . ");
		log.info("encryptFilter : <<doAdd");
		
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
		
		buf = AES.decrypt(buf, secretKey);
		
		String strBuff = new String(buf);
		log.info("encryptFilter : >>doRetreive key = " + key + " -- buf : "+ strBuff +" . ");
		log.info("encryptFilter : <<doRetreive");
		
		return buf;
	}

	
	

}
