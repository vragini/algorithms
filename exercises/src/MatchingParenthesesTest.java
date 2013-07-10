import junit.framework.Assert;

import org.junit.Test;


public class MatchingParenthesesTest {
	
	
	@Test
	public void testStringWithMatchingParentheses(){
		String testString ="((())())()";
		Assert.assertEquals(true, MatchingParentheses.match(testString));
	}
	
	@Test
	public void testStringWithNoMatchingParentheses(){
		String testString1 =")()(";
		Assert.assertEquals(false, MatchingParentheses.match(testString1));
		
		String testString2 = "())";
		Assert.assertEquals(false, MatchingParentheses.match(testString2));
	}
}
