package crimson.cache;
/**
 * Implementation class for LRU eviction.
 * @author ragini
 *
 */

public class LRUEvictionStrategy extends AbstractEvictionStrategy {

	LRUList lruList = new LRUList();
	
	@Override
	public String getKeyToEvict() {
		return lruList.poll();
	}
	
	@Override
	public void keyAdded(String key) {
		lruList.append(key);
	}
	
	@Override
	public void keyUpdated(String key) {
		lruList.pushToTail(key);
	}
	
	@Override
	public void keyUsed(String key) {
		lruList.pushToTail(key);
	}

}
