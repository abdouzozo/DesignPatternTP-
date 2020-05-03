package fr.ensim.dp.cache.filter;
import fr.ensim.dp.cache.ICache;


public class CountFilter implements IFilterCache {
	
	private ICache cache;
	private int countAdd;
	private int countRetrieve;
	
	public CountFilter(ICache cache) {
		this.cache = cache;
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
		cache.add(key, buf);
		countAdd++;
		return buf;
	}

	@Override
	public byte[] doRetreive(String key, byte[] buf) {
		countRetrieve++;
		return cache.retreive(key);
	}

	@Override
	public IFilterCache setNext(IFilterCache next) {
		return null;
	}
	
	

}
