import static org.junit.Assert.*;

import org.junit.Test;

import fr.ensim.dp.cache.MemoryCache;

public class MemoryCacheTest {

	
	
	@Test
	public void testAll() {
		MemoryCache mc = MemoryCache.getInstance();
		String str = "12";
		byte[] bytes_1 = str.getBytes();
		mc.add("ab", bytes_1);
		str = "14";
		byte[] bytes_2 = str.getBytes();
		mc.add("cd", bytes_2);
		
		assertEquals(bytes_1,mc.table_hachage.get("ab"));
		assertEquals(mc.size(),bytes_1.length + bytes_2.length);
		
		byte[] bytes_recherche = mc.retreive("ab");
        assertEquals(bytes_recherche,bytes_1);
		
		mc.clear();
		assertEquals(mc.size(),0);
		
	}

}
