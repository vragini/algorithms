import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


public class RandomCache<K,V> extends Cache<K, V>{
	
	private final int capacity;
	
	public RandomCache(int capacity) {
		this.capacity = capacity;
		list = new ArrayList<>();
		map = new ConcurrentHashMap<>(capacity);
	}

	@Override
	public void add(K key, V value) {
		if(key==null || value == null) {
			throw new NullPointerException();
		}
		if(exists(key)) {
			list.remove(key);
		}
		while(list.size()>= capacity) {
			int random = 0 + (int)(Math.random() * ((list.size() - 0) + 1));
			K expiredKey = list.get(random);
			if(expiredKey != null) {
				map.remove(expiredKey);
			}
		}
		list.add(key);
		map.put(key, value);
		
	}

}
