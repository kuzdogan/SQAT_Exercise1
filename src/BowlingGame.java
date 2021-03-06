import java.util.ArrayList;
import java.util.List;

//Finish time: 16:50
//ID: 138

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame() throws BowlingException{
		bonus = new Frame(0,0); // Avoid null pointer exception.
	}
	
	// adds a frame to the game
	public void addFrame(Frame frame) throws BowlingException{
		if (frames.size() >= 10)
			throw new BowlingException();
		frame.setFrameNum(frames.size()+1);
		
		// If not the first frame, set the scores.
		// Here set the nextThrow values of prev frames.
		if(frame.getFrameNum() > 1){
			Frame prevFrame = frames.get(frame.getFrameNum()-2); // -2 for accessing index starting from 0
			
			// Check if strike.
			if(frame.isStrike()){
				// If a strike check if double strike.
				if(prevFrame.isStrike() && frame.getFrameNum() > 2){
					Frame prevPrevFrame = frames.get(frame.getFrameNum()-3); // -3 for accessing index starting from 0
					// If double strike set as 2. next throw of prev prev frame
					if(prevPrevFrame.isStrike()){
						prevPrevFrame.setNextThrow2(10);
					} else{
						prevFrame.setNextThrow1(10);
					}
				}		
			}
			else{
				prevFrame.setNextThrow1(frame.getFirstThrow());
				prevFrame.setNextThrow2(frame.getSecondThrow());
			}
		}
		if (frame.getFrameNum() == 10){
			if(frame.isStrike()){
				frame.setNextThrow1(bonus.getFirstThrow());
				frame.setNextThrow2(bonus.getSecondThrow());
			}
			if(frame.isSpare()){
				frame.setNextThrow1(bonus.getFirstThrow());
			}
		}
		frames.add(frame);
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {
		this.bonus.setFirstThrow(firstThrow);
		this.bonus.setSecondThrow(secondThrow);
		
		frames.get(9).setNextThrow1(firstThrow);
		frames.get(9).setNextThrow2(secondThrow);
		
	}
	
	// Returns the game score
	public int score() throws BowlingException {
		int total = 0;
		for (int i = 0; i < frames.size(); i++) {
			total += frames.get(i).score();
		}
		// Get all scores of frames by calling their score method
		// If 10 shots made add bonus too
		return total;
	}
	
	// Returns the frame number i.
	public Frame getFrame(int i){
		return frames.get(i-1);
	}
}
