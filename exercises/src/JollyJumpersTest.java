import junit.framework.Assert;

import org.junit.Test;

/**
 * A sequence of n > 0 integers is called a jolly jumper if the absolute values of the difference between successive elements
 * take on all the values 1 through n-1. For instance, 1 4 2 3 is a jolly jumper, because the absolutes differences 
 * are 3, 2, and 1 respectively. The definition implies that any sequence of a single integer is a jolly jumper.
 * You are to write a program to determine whether or not each of a number of sequences is a jolly jumper. 
 * @author ragini
 *
 */

public class JollyJumpersTest {
	
	@Test
	public void testJJInputOne(){
		Assert.assertEquals("Jolly", JollyJumpers.solveJollyJumpers("5 1 4 2 3"));
	}
	
	@Test
	public void testJJInputTwo() {
		Assert.assertEquals("Not Jolly", JollyJumpers.solveJollyJumpers("5 1 4 2 -1 6"));
	}
	
	@Test
	public void testJJInputMany() {
		Assert.assertEquals("Jolly", JollyJumpers.solveJollyJumpers("2 -1 0 2"));
		Assert.assertEquals("Jolly", JollyJumpers.solveJollyJumpers("19 22 24 25"));
		Assert.assertEquals("Not Jolly", JollyJumpers.solveJollyJumpers("19 22 24 21"));
	}
}
