package crimson.cache;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/**
 * Implementation class for Random eviction.
 */

public class RandomEvictionStrategy extends AbstractEvictionStrategy{
	private List<String> list = new LinkedList<>();
	
	private Random random = new Random();

	@Override
	public String getKeyToEvict() {
		int randomNumber = random.nextInt(list.size());
		return list.remove(randomNumber);
	}
	
	@Override
	public void keyAdded(String key) {
		list.add(key);
	}
}
