package crimson.cache;

import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.Assert;

import org.junit.Test;
/**
 * Test for {@link Cache}
 * @author ragini
 *
 */
public class CacheTest {

	@Test
	public void testCreate() {
		Assert.assertNotNull(Cache.create(10,new RandomEvictionStrategy()));
	}
	
	@Test
	public void testAdd(){
		final AtomicInteger addedCount = new AtomicInteger();
		final AtomicInteger updatedCount = new AtomicInteger();
		
		Cache newCache = Cache.create(10, new RandomEvictionStrategy() {
			@Override
			public void keyAdded(String key) {
				addedCount.incrementAndGet();
				super.keyAdded(key);
			}
			@Override
			public void keyUpdated(String key) {
				updatedCount.incrementAndGet();
				super.keyUpdated(key);
			}
			
		});
		newCache.add("key","value");
		newCache.add("key","value");
		
		Assert.assertTrue(newCache.exists("key"));
		Assert.assertEquals(1, addedCount.get());
		Assert.assertEquals(1, updatedCount.get());
	}
	
	@Test
	public void testGet() {
		Cache cache = Cache.create(10, new RandomEvictionStrategy());
		cache.add("key", "value");
		Assert.assertEquals("value", cache.get("key"));
	}
	
	@Test
	public void testEviction() {
		Cache cache = Cache.create(1,new RandomEvictionStrategy());
		cache.add("key1","value1");
		cache.add("key2", "value2");
		Assert.assertFalse(cache.exists("key1"));
	}
	
	@Test
	public void testLRUEviction() {
		Cache cache = Cache.create(2,new LRUEvictionStrategy());
		cache.add("key1","value");
		cache.add("key2", "value");
		cache.add("key3", "value");
		
		Assert.assertFalse(cache.exists("key1"));
		
		Assert.assertTrue(cache.exists("key2"));
		Assert.assertTrue(cache.exists("key3"));
		//
		cache.get("key2");
		cache.add("key4", "value");
		Assert.assertTrue(cache.exists("key2"));
		Assert.assertFalse(cache.exists("key3"));
	}
}
