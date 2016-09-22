public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	// Variables for calculating strike/spare scores
	// Assigned on BowlingGame.addFrame() method
	private int nextThrow1, nextThrow2;
	// TODO: A better way to do?
	
	// Frame number to access other frames.
	private int frameNum;
	// TODO: Can we use another method to access other frames in the game?

	public Frame(int firstThrow, int secondThrow) throws BowlingException {
		if (firstThrow + secondThrow > 10)
			throw new BowlingException();
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getNextThrow1() {
		return nextThrow1;
	}

	public void setNextThrow1(int nextThrow1) {
		this.nextThrow1 = nextThrow1;
	}

	public int getNextThrow2() {
		return nextThrow2;
	}

	public void setNextThrow2(int nextThrow2) {
		this.nextThrow2 = nextThrow2;
	}

	public void setFirstThrow(int firstThrow) {
		this.firstThrow = firstThrow;
	}

	public void setSecondThrow(int secondThrow) {
		this.secondThrow = secondThrow;
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
	
	// TODO: Write test
	public void setFrameNum(int num){
		this.frameNum = num;
	}
	
	//TODO: Write test
	public int getFrameNum(){
		return this.frameNum;
	}
}
