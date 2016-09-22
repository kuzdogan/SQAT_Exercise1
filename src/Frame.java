public class Frame {
	private int firstThrow;
	private int secondThrow;

	public Frame(int firstThrow, int secondThrow) throws BowlingException {
		if (firstThrow + secondThrow > 10)
			throw new BowlingException();
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	// returns the score of a single frame
	public int score() {
		if (this.isStrike()) {

		}

		else if (this.isSpare()) {

		}
		
		else {
			return firstThrow + secondThrow;
		}
		// to be implemented
		return 0;
	}

	// returns whether the frame is a strike or not
	public boolean isStrike() {
		if (firstThrow == 10)
			return true;
		// to be implemented
		return false;
	}

	// return whether a frame is a spare or not
	public boolean isSpare() {
		if ((firstThrow + secondThrow == 10) && firstThrow != 10)
			return true;
		return false;
	}
}
