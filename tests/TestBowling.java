import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;

public class TestBowling {
	
	@Test
	public void testFrame_4_3() throws BowlingException {
		Frame testFrame = new Frame(4, 3);
		
		// Expect no exceptions.
	}
	
	@Test
	public void testFrame_4_3() throws BowlingException {
		Frame testFrame = new Frame(4, 3);
		
		// Expect no exceptions.
	}
	
	@Test
	public void testSpare_4_3() throws BowlingException {
		Frame testFrame = new Frame(4, 3);

		assertFalse(testFrame.isSpare());
	}

	@Test
	public void testSpare_10_0() throws BowlingException {
		Frame testFrame = new Frame(10, 0);

		assertFalse(testFrame.isSpare());
	}

	@Test
	public void testSpare_2_8() throws BowlingException {
		Frame testFrame = new Frame(2, 8);

		assertTrue(testFrame.isSpare());
	}

	@Test
	public void testStrike_4_3() throws BowlingException {
		Frame testFrame = new Frame(4, 3);

		assertFalse(testFrame.isStrike());
	}

	@Test
	public void testStrike_10_0() throws BowlingException {
		Frame testFrame = new Frame(10, 0);

		assertTrue(testFrame.isStrike());
	}

	@Test
	public void testStrike_2_8() throws BowlingException {
		Frame testFrame = new Frame(2, 8);

		assertFalse(testFrame.isStrike());
	}
}
