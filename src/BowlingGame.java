import java.util.ArrayList;
import java.util.List;

//Finish time:
//ID:

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame(Frame frame) throws BowlingException{
		if (frames.size() >= 10)
			throw new BowlingException();
		frame.setFrameNum(frames.size()+1);
		
		// If not the first frame, set the scores.
		// Here set the nextThrow values of prev frames.
		if(frame.getFrameNum() > 1){
			Frame prevFrame = frames.get(frame.getFrameNum()-1);
			
			// If a strike check if double strike.
			if(frame.isStrike()){
				// If double strike set as 2. next throw of prev prev frame
				if(prevFrame.isStrike() frame.getFrameNum() > 2){
					Frame prevPrevFrame = frames.get(frame.getFrameNum()-2);
					prevPrevFrame.setNextThrow2(10);
				} else{
					prevFrame.setNextThrow1(10);
				}
			} else{
				prevFrame.setNextThrow1(frame.getFirstThrow());
				prevFrame.setNextThrow2(frame.getSecondThrow());
			}
			
		}
		frames.add(frame);
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	// Returns the game score
	public int score(){
		// Get all scores of frames by calling their score method
		// If 10 shots made add bonus too
		return 0;
	}
	
	// Returns the frame number i.
	public Frame getFrame(int i){
		return frames.get(i);
	}
}
