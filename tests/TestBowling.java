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
		
		assertEquals(frame, game.getFrame(1));
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
	public void testNextThrow() throws BowlingException {
		BowlingGame game = new BowlingGame();
		
		// Add 10 frames.
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(4, 2));

		assertEquals(2, game.getFrame(2).getNextThrow2());
	}
	@Test
	public void testNextThrowOneStrike() throws BowlingException {
		BowlingGame game = new BowlingGame();
		
		// Add 10 frames.
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(4, 2));

		assertEquals(2, game.getFrame(3).getNextThrow2());
	}
	
	@Test
	public void testAddFrameTripleStrike() throws BowlingException {
		BowlingGame game = new BowlingGame();
		
		// Add 10 frames.
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));

		assertEquals(10, game.getFrame(3).getNextThrow2());
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
	
	@Test
	public void testGameScore1FrameSpare() throws BowlingException {
		BowlingGame game = new BowlingGame();		
		Frame frame = new Frame(3, 7);
		
		game.addFrame(frame);
		
		assertEquals(10,game.score());
	}
	
	@Test
	public void testGameScore1FrameStrike() throws BowlingException {
		BowlingGame game = new BowlingGame();		
		Frame frame = new Frame(10,0);
		
		game.addFrame(frame);
		
		assertEquals(10,game.score());
	}
	
	@Test
	public void testGameScore4Frame() throws BowlingException {
		BowlingGame game = new BowlingGame();		
		game.addFrame(new Frame(3, 4));
		game.addFrame(new Frame(1, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(3, 4));
		
		assertEquals(32, game.score());
	}
	@Test
	public void testGameScore4FrameWithSpare() throws BowlingException {
		BowlingGame game = new BowlingGame();		
		game.addFrame(new Frame(3, 4));
		game.addFrame(new Frame(1, 0));
		game.addFrame(new Frame(4, 6));
		game.addFrame(new Frame(3, 4));
		
		assertEquals(28, game.score());
	}
	
	@Test
	public void testGameScore4FrameDoubleStrike() throws BowlingException {
		BowlingGame game = new BowlingGame();		
		game.addFrame(new Frame(3, 4));
		game.addFrame(new Frame(1, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		
		assertEquals(38, game.score());
	}
	
	@Test
	public void testGameScore10Frame() throws BowlingException {
		BowlingGame game = new BowlingGame();		
		game.addFrame(new Frame(3, 4));
		game.addFrame(new Frame(1, 0));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(2, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(2, 0));
		game.addFrame(new Frame(2, 3));
		
		assertEquals(52, game.score());
	}
	@Test
	public void testGameScore10Frame2() throws BowlingException {
		BowlingGame game = new BowlingGame();		
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		
		assertEquals(0, game.score());
	}
	
	@Test
	public void testGameScore10FrameBonus() throws BowlingException {
		BowlingGame game = new BowlingGame();		
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(5, 2));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(10, 0));
		game.setBonus(2, 5);
		
		assertEquals(24, game.score());
	}
	@Test
	public void testGameScore10FrameGivenExample() throws BowlingException {
		BowlingGame game = new BowlingGame();		
		game.addFrame(new Frame(1, 4));
		game.addFrame(new Frame(4, 5));
		game.addFrame(new Frame(6, 4));
		game.addFrame(new Frame(5, 5));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(0, 1));
		game.addFrame(new Frame(7, 3));
		game.addFrame(new Frame(6, 4));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(2, 8));
		game.setBonus(6, 5);
		
		assertEquals(133, game.score());
	}
	
}
