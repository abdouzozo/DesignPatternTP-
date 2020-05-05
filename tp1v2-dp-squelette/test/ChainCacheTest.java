import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.ensim.dp.cache.DiskCache;
import fr.ensim.dp.cache.MemoryCache;
import fr.ensim.dp.cache.filter.CompressFilterCache;
import fr.ensim.dp.cache.filter.CountFilter;
import fr.ensim.dp.cache.filter.EncryptFilterCache;
import fr.ensim.dp.cache.filter.LogFilterCache;


public class ChainCacheTest {
	
	@Test
	public void testMemoryCache() { 
		
		CountFilter countFilter = new CountFilter();
		LogFilterCache logFilter = new LogFilterCache();
		EncryptFilterCache encryptFilter = new EncryptFilterCache();
		CompressFilterCache compressFilter = new CompressFilterCache();
		
		countFilter.setNext(compressFilter);
		compressFilter.setNext(logFilter);
		logFilter.setNext(encryptFilter);
		
		//logFilter.setNext(encryptFilter);
		//encryptFilter.setNext(compressFilter);
		
		
		MemoryCache.getInstance().setFilter(countFilter); 
		
		String str = "12";
		byte[] bytes_1 = str.getBytes();
		MemoryCache.getInstance().add("ab", bytes_1);
		
		/*str = "14";
		byte[] bytes_2 = str.getBytes();
		MemoryCache.getInstance().add("cd", bytes_2); */
		
		String str_recup = new String(MemoryCache.getInstance().retreive("ab"));
		assertEquals(str_recup,"12");
		
		
		
        MemoryCache.getInstance().clear();
		assertEquals(MemoryCache.getInstance().size(),0);

	}
	
	@Test
	public void testDiskCache() { 
		
		CountFilter countFilter = new CountFilter();
		LogFilterCache logFilter = new LogFilterCache();
		EncryptFilterCache encryptFilter = new EncryptFilterCache();
		CompressFilterCache compressFilter = new CompressFilterCache();
		
		countFilter.setNext(compressFilter);
		compressFilter.setNext(logFilter);
		logFilter.setNext(encryptFilter);
		
		//logFilter.setNext(encryptFilter);
		//encryptFilter.setNext(compressFilter);
		
		
		DiskCache.getInstance("map_1").setFilter(countFilter);
		
		String str_buf = "A1D6587F821";
		byte[] bytes_buf = str_buf.getBytes();
		DiskCache.getInstance("map_1").add("Image_1_1", bytes_buf);
		
		
		
		String str_recup = new String(DiskCache.getInstance("map_1").retreive("Image_1_1"));
		assertEquals(str_recup,"A1D6587F821");
		
		
		
		DiskCache.getInstance("map_1").clear();
		assertEquals(DiskCache.getInstance("map_1").size(),0);

	}

}
