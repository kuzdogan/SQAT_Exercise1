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
		
		// Add 10 frames.
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		
		// Excessive frame.
		game.addFrame(new Frame(5, 3));
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
	
	@Test
	public void testGameScore1Frame() throws BowlingException {
		BowlingGame game = new BowlingGame();		
		Frame frame = new Frame(3, 4);
		
		game.addFrame(frame);
		
		assertEquals(7,game.score());
	}
}
