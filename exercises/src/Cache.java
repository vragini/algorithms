import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


public abstract class Cache<K,V> {
	public ConcurrentLinkedQueue<K> queue;
	public ConcurrentHashMap<K, V> map;
	public List<K> list;
	
	public Cache<K, V> create(int size, String evictionStrategy){
			
		if(evictionStrategy.equals("LRU")) {
			LRUCache<K, V> LRUCache = new LRUCache<>(size);
			return LRUCache;
		}else {
			RandomCache<K, V> randomCache = new RandomCache<>(size);
			return randomCache;
		}
	}
	
	public abstract void add(K key, V value);
	
	public V get(K key) {
		return map.get(key);
	}
	
	public boolean exists(K key) {
		return map.containsKey(key);
	}
	
}
