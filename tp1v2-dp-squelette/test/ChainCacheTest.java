import org.junit.Test;

import fr.ensim.dp.cache.filter.CompressFilterCache;
import fr.ensim.dp.cache.filter.CountFilter;
import fr.ensim.dp.cache.filter.EncryptFIlterCache;
import fr.ensim.dp.cache.filter.EncryptFilterCache;
import fr.ensim.dp.cache.filter.LogFilterCache;


public class ChainCacheTest {
	
	@Test
	public void testAdd() { 
		
		CountFilter countFilter = new CountFilter();
		LogFilterCache logFilter = new LogFilterCache();
		EncryptFilterCache encryptfiller = new EncryptFilterCache();
		CompressFilterCache compressFilter = new CompressFilterCache();
		
		
		
		
		
	}

}
