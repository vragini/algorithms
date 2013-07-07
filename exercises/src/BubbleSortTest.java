import org.junit.Assert;
import org.junit.Test;


public class BubbleSortTest {
	
	@Test
	public void testBubbleSort() {
		int[] array = new int[]{2,1,8,4,36,12,6};
		BubbleSort.sort(array);
		Assert.assertArrayEquals(new int[]{1,2,4,6,8,12,36}, array);
	}
	
	@Test
	public void testSortedArray() {
		int[] array = new int[]{1,2,3};
		BubbleSort.sort(array);
		Assert.assertArrayEquals(new int[]{1,2,3}, array);
	}
}
