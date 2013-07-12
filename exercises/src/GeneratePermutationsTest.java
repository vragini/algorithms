import java.util.List;

import junit.framework.Assert;

import org.junit.Test;


public class GeneratePermutationsTest {
	
	@Test
	public void testGenerateTwoNumberPermutations(){
		
		boolean[] used = {false,false,false};
		int[] sol = {0,0};
		List<int[]> listOfPerms = GeneratePermutations.generatePerm(used, 2, 0, sol);
		Assert.assertEquals(2, listOfPerms.size());
		
	}

}
