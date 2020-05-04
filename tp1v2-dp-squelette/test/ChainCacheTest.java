import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.ensim.dp.cache.MemoryCache;
import fr.ensim.dp.cache.filter.CompressFilterCache;
import fr.ensim.dp.cache.filter.CountFilter;
import fr.ensim.dp.cache.filter.EncryptFilterCache;
import fr.ensim.dp.cache.filter.LogFilterCache;


public class ChainCacheTest {
	
	@Test
	public void testAdd() { 
		
		CountFilter countFilter = new CountFilter();
		LogFilterCache logFilter = new LogFilterCache();
		//EncryptFilterCache encryptFilter = new EncryptFilterCache();
		CompressFilterCache compressFilter = new CompressFilterCache();
		
		countFilter.setNext(compressFilter);
		compressFilter.setNext(logFilter);
		
		//logFilter.setNext(encryptFilter);
		//encryptFilter.setNext(compressFilter);
		
		
		MemoryCache.getInstance().setFilter(countFilter);
		
		String str = "12";
		byte[] bytes_1 = str.getBytes();
		MemoryCache.getInstance().add("ab", bytes_1);
		
		str = "14";
		byte[] bytes_2 = str.getBytes();
		MemoryCache.getInstance().add("cd", bytes_2);
		
		String str_recup = new String(MemoryCache.getInstance().retreive("ab"));
		assertEquals(str_recup,"12");
		
		
		
        MemoryCache.getInstance().clear();
		assertEquals(MemoryCache.getInstance().size(),0);
		
		
		
	}

}
