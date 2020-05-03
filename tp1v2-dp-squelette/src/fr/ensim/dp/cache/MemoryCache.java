package fr.ensim.dp.cache;

import java.util.HashMap;

public class MemoryCache implements ICache {
	
	
	private static MemoryCache singleton = new MemoryCache();
	public HashMap<String, byte[]> table_hachage = new HashMap<String, byte[]>();
	
	private MemoryCache() {
		
	}
	
	public static MemoryCache getInstance() {
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
		
		table_hachage.put(key, buf);
		
		return true;
	}

	@Override
	public byte[] retreive(String key) {
		byte[] tmp = table_hachage.get(key);
		
		return tmp;
	}

	@Override
	public void clear() {
		table_hachage.clear();
	}

}
