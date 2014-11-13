package crimson.cache;

import org.junit.Assert;
import org.junit.Test;

import crimson.cache.LRUList.Node;

/**
 * Test for {@link LRUList}
 * @author ragini
 *
 */
public class LRUListTest {
	
	@Test
	public void testEmpty(){
		LRUList list = new LRUList();
		Assert.assertNull(list.poll());
	}
	
	@Test
	public void testPoll(){
		LRUList list = new LRUList();
		list.append("first");
		list.append("second");
		Assert.assertEquals("first", list.poll());
		Assert.assertEquals("second", list.poll());
		Assert.assertNull(list.poll());
	}
	
	
	@Test
	public void testPushSecond(){
		LRUList list = new LRUList();
		list.append("first");
		list.append("second");
		list.append("third");
		list.pushToTail("second");
		
		Assert.assertEquals("first", list.poll());
		Assert.assertEquals("third", list.poll());
		Assert.assertEquals("second", list.poll());
		Assert.assertNull(list.poll());
	}
	
	@Test
	public void testPushHead(){
		LRUList list = new LRUList();
		list.append("first");
		list.append("second");
		list.append("third");
		
		list.pushToTail("first");
		
		Assert.assertEquals("second", list.poll());
		Assert.assertEquals("third", list.poll());
		Assert.assertEquals("first", list.poll());
		Assert.assertNull(list.poll());
	}
	
	
	@Test
	public void testLinks(){
		LRUList list = new LRUList();
		Node first = list.append("first");
		Node second = list.append("second");
		Node third = list.append("third");
		
		Assert.assertEquals(list.head, first);
		Assert.assertNull(list.head.prev);
		Assert.assertEquals(list.tail, third);
		Assert.assertNull(list.tail.next);
		
		Assert.assertEquals(first.next, second);
		Assert.assertEquals(second.next, third);
		
		Assert.assertEquals(third.prev, second);
		Assert.assertEquals(second.prev, first);
		
		list.pushToTail("first");
		
		Assert.assertEquals(list.head, second);
		Assert.assertNull(list.head.prev);
		
		Assert.assertEquals(list.tail, first);
		Assert.assertNull(list.tail.next);
		
		Assert.assertEquals(second.next, third);
		Assert.assertEquals(third.next, first);
		
		Assert.assertEquals(first.prev, third);
		Assert.assertEquals(third.prev, second);
		
	}
}
