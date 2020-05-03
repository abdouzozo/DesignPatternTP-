import static org.junit.Assert.*;

import org.junit.Test;

import fr.ensim.dp.cache.FactoryCache;
import fr.ensim.dp.cache.ICache;

public class FactoryCacheTest {
	
	@Test
	public void testAll() {
		ICache dc = FactoryCache.getDiskCache("map_1");
		assertEquals(0,dc.size());
		
		ICache mc = FactoryCache.getMemoryCache();
		String str = "12";
		byte[] bytes_1 = str.getBytes();
		mc.add("ab", bytes_1);
		assertEquals(bytes_1,mc.retreive("ab"));
	}

}
