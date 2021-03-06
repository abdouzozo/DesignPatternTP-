package fr.ensim.dp.cache;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;

import fr.ensim.dp.cache.filter.IFilterCache;
import fr.ensim.dp.util.FileUtil;

public class DiskCache implements ICache {
	
	private static HashMap<String, DiskCache> map = new HashMap<String, DiskCache>(); //repertoire
	
	private String dir;
	private File dirFile;
	private IFilterCache filter;
	
	public IFilterCache getFilter() {
		return filter;
	}

	public void setFilter(IFilterCache filter) {
		this.filter = filter;
	}

	HashMap<String, byte[]> mapImages = new HashMap<>();
		
	private DiskCache(String dir) {
		this.dir = dir;
		this.dirFile = new File(this.dir);
        this.dirFile.mkdir();
	}

	public static DiskCache getInstance(String dir) {
		
		DiskCache d = map.get(dir);
		if(d==null) {
		 DiskCache di = new DiskCache(dir);
			map.put(dir, di );
			
		}
		return map.get(dir);
		
	}
	
	@Override
	public long size() {
        long size = 0;
        for (String i : mapImages.keySet()) {
        	size += mapImages.get(i).length;
        }
        return size;
		//return FileUtil.dirLength(dirFile);
    }

	@Override
	public boolean add(String key, byte[] buf) {
		File file = new File(dir, key);
		boolean isInCache = FileUtil.copy(new ByteArrayInputStream(buf), file);
		if(filter == null)
			mapImages.put(key, buf);
		else {
			buf = filter.doAdd(key, buf);
			mapImages.put(key, buf);
		}
		return isInCache;
	}

	@Override
	public byte[] retreive(String key) {
		
		byte[] imageContenu = mapImages.get(key);
		return (filter == null) ? imageContenu : filter.doRetreive(key, imageContenu);

	}

	@Override
	public void clear() {
		 mapImages.clear();
		 for(File file : dirFile.listFiles()){
		       file.delete();
		   }
	}

}
