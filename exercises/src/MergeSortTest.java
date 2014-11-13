import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;




public class MergeSortTest {
	
	private int [] numbers;
	
	@Before
	public void setup(){
		numbers= new int[]{3,1,6,34,12,2};
	}
	
	@Test
	public void testMergeSort() {
		MergeSort mergesort = new MergeSort();
		int[] sorted = mergesort.sort(numbers);
		Assert.assertArrayEquals(new int[]{1,2,3,6,12,34}, sorted);
	}
	
	// a [4,5,6]
	// b [3,4,5,7]
	
	// c = a + b = [ 1, 2, 2, 3, ]
}
