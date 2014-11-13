
import junit.framework.Assert;

import org.junit.Test;


public class PowerOfNumberTest {
	
	@Test
	public void testPowerOfNumber(){
		PowerOfNumber result = new PowerOfNumber();
		 Assert.assertEquals(8.0, result.getPower(0, -1));
	}

}
