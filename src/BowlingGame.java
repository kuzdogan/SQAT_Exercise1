import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Finish time:
//ID:

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private Queue<Integer> shotQueue = new LinkedList<Integer>();
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame(Frame frame) throws BowlingException{
		if (frames.size() >= 10)
			throw new BowlingException();
		frame.setFrameNum(frames.size()+1);
		shotQueue.add(frame.getFirstThrow());
		shotQueue.add(frame.getSecondThrow());
		
		// If not the first frame, set the scores as 
		if(frame.getFrameNum() != 1){
			Frame prevFrame = frames.get(frame.getFrameNum()-1);
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
