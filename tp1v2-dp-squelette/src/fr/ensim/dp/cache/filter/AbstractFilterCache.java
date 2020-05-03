package fr.ensim.dp.cache.filter;



import org.apache.log4j.Logger;

import fr.ensim.dp.util.LoggerUtil;

public abstract class AbstractFilterCache implements IFilterCache {

	public static final Logger LOG = LoggerUtil.getLogger();
	
	protected AbstractFilterCache next;
	public AbstractFilterCache setNext(AbstractFilterCache next) {
		this.next = next;
		return this.next;
	}

}
