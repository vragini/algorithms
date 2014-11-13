import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;


public class GeneratePermutationsTest {
	
	@Test
	public void testGenerateOneNumberPermutations(){
		List<int[]> listOfPerms = GeneratePermutations.generatePerm(1);
		Assert.assertEquals(1, listOfPerms.size());
	}
	
	
	@Test
	public void testGenerateTwoNumberPermutations(){
		List<int[]> listOfPerms = GeneratePermutations.generatePerm(2);
		Assert.assertEquals(2, listOfPerms.size());
		for(int[] each :listOfPerms){
			System.out.println(Arrays.toString(each));
		}
	}
	
	@Test
	public void testGenerateThreeNumberPermutations(){
		List<int[]> listOfPerms = GeneratePermutations.generatePerm(3);
		Assert.assertEquals(6, listOfPerms.size());
		for(int[] each :listOfPerms){
			System.out.println(Arrays.toString(each));
		}
	}

}
