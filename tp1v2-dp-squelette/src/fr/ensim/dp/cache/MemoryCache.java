package fr.ensim.dp.cache;

import java.util.HashMap;

import fr.ensim.dp.cache.filter.IFilterCache;

public class MemoryCache implements ICache {
	
	
	private static MemoryCache singleton = new MemoryCache();
	
	public HashMap<String, byte[]> table_hachage = new HashMap<String, byte[]>();
	
	private IFilterCache filter = null;
	
	public IFilterCache getFilter() {
		return filter;
	}

	public void setFilter(IFilterCache filter) {
		this.filter = filter;
	}

	private MemoryCache() {
		
	}
	
	public static  MemoryCache getInstance() {
		return singleton;
	}
	
	

	@Override
	public long size() {
		
		long size = 0;
		for (String i : table_hachage.keySet()) {
			  size += table_hachage.get(i).length;
			}
		
		return size;
	}

	@Override
	public boolean add(String key, byte[] buf) {
		if(filter == null)
			table_hachage.put(key, buf);
		else {
			buf = filter.doAdd(key, buf);
			table_hachage.put(key, buf);
		}
		return true;
	}

	@Override
	public byte[] retreive(String key) {
		byte[] tmp = table_hachage.get(key);

		return (filter == null) ? tmp : filter.doRetreive(key, tmp);
	}

	@Override
	public void clear() {
		table_hachage.clear();
	}

}
