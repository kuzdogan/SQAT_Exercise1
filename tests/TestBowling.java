import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;

public class TestBowling {
	
	@Test
	public void testFrame_4_3() throws BowlingException {
		new Frame(4, 3);
		
		// Expect no exceptions.
	}
	
	@Test (expected = BowlingException.class)
	public void testFrame_4_9() throws BowlingException {
		new Frame(4, 9);
		
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
		
		assertEquals(frame, game.getFrame(0));
	}
	
	@Test (expected = BowlingException.class)
	public void testAddFrameOutOfBounds() throws BowlingException {
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(5, 3);
		
		// Add 10 frames.
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		
		// Excessive frame.
		game.addFrame(frame);
	}
	
	@Test
	public void testFrameScore_5_3() throws BowlingException {
		Frame frame = new Frame(5, 3);
		
		assertEquals(8, frame.score());
	}
	
	@Test
	public void testFrameScore_5_5() throws BowlingException {
		Frame frame = new Frame(5, 5);
		
		assertEquals(10, frame.score());
	}
	
	@Test
	public void testFrameScore_10_0() throws BowlingException {
		Frame frame = new Frame(10, 0);
		
		assertEquals(10, frame.score());
	}
}
