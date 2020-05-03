package fr.ensim.dp.cache;



public class FactoryCache {
	private FactoryCache() {}
	
	public static ICache getMemoryCache() {
		return MemoryCache.getInstance();
	}
	
	public static ICache getDiskCache(String dirCache) {
		
		return DiskCache.getInstance(dirCache);
	}

}
