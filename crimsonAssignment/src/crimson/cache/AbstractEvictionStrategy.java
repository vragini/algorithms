package crimson.cache;
/**
 * Abstract class using strategy pattern for eviction of cache entries.
 * Implementation classes {@link LRUEvictionStrategy} and {@link RandomEvictionStrategy}
 * @author ragini
 *
 */

public abstract class AbstractEvictionStrategy {

	public void keyAdded(String key) {};
	
	public void keyUpdated(String key) {};

	public void keyUsed(String key) {};

	public abstract String getKeyToEvict();

}
