import junit.framework.Assert;

import org.junit.Test;


public class MatchingParenthesesTest {
	
	
	@Test
	public void testStringWithMatchingParentheses(){
		String testString ="((())())()";
		Assert.assertEquals(0, MatchingParentheses.findMismatchPosition(testString));
	}
	
	@Test
	public void testLeftMismatch(){
		Assert.assertEquals(1, MatchingParentheses.findMismatchPosition("("));
	}
	
	@Test
	public void testRightMismatch(){
		Assert.assertEquals(1, MatchingParentheses.findMismatchPosition(")"));
	}
	
	@Test
	public void testMismatchPosition(){
		Assert.assertEquals(3, MatchingParentheses.findMismatchPosition("()((()"));
	}
	
	@Test
	public void testBookExample(){
		String testString1 =")()(";
		Assert.assertEquals(1, MatchingParentheses.findMismatchPosition(testString1));
		
		String testString2 = "())";
		Assert.assertEquals(3, MatchingParentheses.findMismatchPosition(testString2));
	}
}
