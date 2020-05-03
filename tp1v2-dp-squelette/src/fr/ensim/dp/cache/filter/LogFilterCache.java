package fr.ensim.dp.cache.filter;

import org.apache.log4j.Logger;
import fr.ensim.dp.util.LoggerUtil;

public class LogFilterCache extends AbstractFilterCache {
	
	private static Logger log = LoggerUtil.getLogger();
	
	
	
	@Override
	public byte[] doAdd(String key, byte[] buf) {
		if(log.isInfoEnabled()) {
			StringBuffer st = new StringBuffer();
			for(byte b : buf) {
				st.append(b);
				st.append(' ');
			}
			log.info(">>doAdd key=" + key + "buf : " + st.toString());
		}
		log.info("<<doAdd");
		if(next != null) {
			buf = next.doAdd(key, buf);
		}
		return buf;
	}
		

	@Override
	public byte[] doRetreive(String key, byte[] buf) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IFilterCache setNext(IFilterCache next) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
