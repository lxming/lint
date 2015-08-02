package lint;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import junit.framework.TestCase;

public class Lru extends TestCase{
	  int capacity = 0;
	    HashMap<Integer, CacheItem> map;
	    PriorityQueue<CacheItem> queue;
	    public Lru() {
	    }

	    // @param capacity, an integer
	    public Lru(int capacity) {
	        this.capacity = capacity;
	        this.map = new HashMap<Integer, CacheItem>();
	        this.queue = new PriorityQueue<CacheItem>(
	        		capacity,
	        		new Comparator<CacheItem>(){
	        			public int compare(CacheItem c1, CacheItem c2) {
	        				return c1.freq - c2.freq;
	        			}
	        		}
	        );
	    }

	    // @return an integer
	    public int get(int key) {
	        if (!map.containsKey(key)){
	            return -1;
	        }
	        CacheItem item = map.get(key);
	        item.freq++;
	        queue.remove(item);
	        queue.add(item);
	        return item.value;
	    }

	    // @param key, an integer
	    // @param value, an integer
	    // @return nothing
	    public void set(int key, int value) {
	        if (map.size()==capacity && !map.containsKey(key)) {
	            CacheItem item = queue.poll();
	            map.remove(item.key);
	        }
	        
	        if (!map.containsKey(key)) {
	            CacheItem item = new CacheItem();
	            item.key = key;
	            item.value=value;
	            item.freq = 1;
	            map.put(key, item);
	            queue.add(item);
	        }
	        else {
	            CacheItem item = map.get(key);
	            item.value = value;
	        }
	    }
	    
		public void testSample() {
			Lru lru = new Lru(2);
			lru.set(2,1);
			lru.set(1,1);
			lru.get(2);
			lru.set(4,1);
			assertEquals(-1, lru.get(1));
		}

	
}
	
class CacheItem {
    int key;
    int value;
    int freq;
    public boolean equals(Object other) {
    	return this.key == ((CacheItem)other).key;
    }
}	
	
