package fr.ensim.dp.cache.filter;

public interface IFilterCache {

		byte[] doAdd(String key, byte[] buf);
		
		byte[] doRetreive(String key, byte[] buf);
		
		public IFilterCache setNext(IFilterCache next);
		
}
