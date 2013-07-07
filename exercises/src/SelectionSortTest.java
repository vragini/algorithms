import org.junit.Assert;
import org.junit.Test;


public class SelectionSortTest {
	
	@Test
	public void testPair() {
		int[] array = new int[]{2,1,1};
		
		SelectionSort.sort(array);
		Assert.assertArrayEquals(new int[]{1,1,2}, array);
	}
	
	@Test
	public void testSelectionSort() {
		int[] array = new int[]{2,1,8,4,36,12,6};
		SelectionSort.sort(array);
		Assert.assertArrayEquals(new int[]{1,2,4,6,8,12,36}, array);
	}
}
