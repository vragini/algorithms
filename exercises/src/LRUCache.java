import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


public class LRUCache<K,V> extends Cache<K, V> {
	private final int capacity;
	
		
	public LRUCache(int capacity) {
		this.capacity = capacity;
		queue = new ConcurrentLinkedQueue<>();
		map = new ConcurrentHashMap<>(capacity);
	}
		
	public synchronized void add(K key, V value) {
		if(key==null || value == null) {
			throw new NullPointerException();
		}
		if(exists(key)) {
			queue.remove(key);
		}
			
		while(queue.size() >= capacity) {
			K expiredKey = queue.poll();
			if(expiredKey != null) {
				map.remove(expiredKey);
			}
		}
			
		queue.add(key);
		map.put(key, value);
	
		
	}
}
	


