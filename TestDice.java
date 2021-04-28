import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class TestDice {
	private Dice d;


	@Before
	public void setUp() throws Exception {
		d = new Dice();
	}

	@After
	public void tearDown() throws Exception {
		d = null;
	}
	

	@Test
	public final void testOnInstanciatin() {
			d = new Dice();
			assertEquals(d.getFaceValue(),0);
			assertEquals(false,d.getfixed());
			Assert.assertFalse(d.getfixed());
			System.out.println("");
			System.out.println("Initial dice state");
		}
	@Test
	public final void faceValue() {
			d = new Dice();
			Assert.assertFalse(d.getFaceValue()==1);
			assertNotEquals(d, null);
			d.roll();
			assertTrue(d.getFaceValue()>0);
			assertTrue(d.getFaceValue()<7);
			
		
			
		
		}

	private void assertFalse(int i, int faceValue) {
		// TODO Auto-generated method stub
		
	}


}