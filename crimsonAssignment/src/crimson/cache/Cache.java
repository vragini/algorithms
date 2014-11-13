package crimson.cache;

import java.util.HashMap;
import java.util.Map;
/**
 * In-memory cache implementation that supports access by keys.
 * @author ragini
 *
 */
public class Cache {
	
	private Map<String,Object> map = new HashMap<>();
	
	private int size;
	private AbstractEvictionStrategy evictionStrategy;
	
	private Cache(int size, AbstractEvictionStrategy evictionStrategy){
		this.size = size;
		this.evictionStrategy = evictionStrategy;
	}

	
	public static Cache create(int size, AbstractEvictionStrategy evictionStrategy) {
		return new Cache(size, evictionStrategy);
	}

	public void add(String key, String value) {
		if(key==null || value==null ) {
			throw new NullPointerException();
		}
		if(map.size()>=size){
			String keyToEvict = evictionStrategy.getKeyToEvict();
			remove(keyToEvict);
		}
		if(map.containsKey(key)) {
			evictionStrategy.keyUpdated(key);
		} else {
			evictionStrategy.keyAdded(key);
		}
		map.put(key, value);
	}

	public boolean exists(String key) {
		return map.containsKey(key);
	}

	public Object get(String key) {
		Object result = map.get(key);
		if (result != null) {
			evictionStrategy.keyUsed(key);
		}
		return result;
	}


	private void remove(String key) {
		map.remove(key);
	}

}
