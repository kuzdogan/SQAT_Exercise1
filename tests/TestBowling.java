import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;

public class TestBowling {
	
	@Test
	public void testFrame_4_3() throws BowlingException {
		Frame testFrame = new Frame(4, 3);
		
		// Expect no exceptions.
	}
	
	@Test (expected = BowlingException.class)
	public void testFrame_4_9() throws BowlingException {
		Frame testFrame = new Frame(4, 9);
		
		// Expect exception to be thrown.
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
	
	@Test
	public void testAddFrame() throws BowlingException {
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(5, 3);
		
		game.addFrame(frame);
		
		
	}
}
