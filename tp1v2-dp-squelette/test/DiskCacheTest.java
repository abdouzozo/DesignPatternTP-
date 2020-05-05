import static org.junit.Assert.*;

import org.junit.Test;

import fr.ensim.dp.cache.DiskCache;


public class DiskCacheTest {
	
	@Test
	public void testAll() {
		DiskCache map_1 = DiskCache.getInstance("map_1");
		DiskCache map_2 = DiskCache.getInstance("map_2");
		
		assertEquals(0,map_1.size());
		
		String str_buf = "A1D6587F821";
		byte[] bytes_buf = str_buf.getBytes();
		map_1.add("Image_1_1", bytes_buf);
		map_1.add("Image_1_2", bytes_buf);
		
		assertEquals(2*bytes_buf.length,map_1.size());
		assertEquals(0,map_2.size());
		
		byte[] recup_Img_1 = map_1.retreive("Image_1_1");
		String recup_Img_1_str = new String(recup_Img_1);
		assertEquals(str_buf,recup_Img_1_str);
		
		byte[] recup_Img_3 = map_1.retreive("Image_1_3");
		
		assertEquals(null,recup_Img_3);
		
		map_1.clear();
		assertEquals(0,map_1.size());
		

		
	}

}
