import java.util.ArrayList;
import java.util.Collections;

// class to create alphabetized lines of the circular shifts using 
// CS-Char and CS-Word;
// provides routines to access shifted lines in alphabetical order
// @author: A0099324X
public class AlphabeticShift {
	
	private ArrayList<String> lines;
	private CircularShift circularShift;
	
	public AlphabeticShift(CircularShift cs){
		circularShift = cs;
		lines = new ArrayList<String>();
	}
	
	// Method to use CircularShift.getChar and CircularShift.getNumWords
	// to create alphabetized lines
	// @return
	//		void
	public void alpha(){
		int numShifts = circularShift.getNumShiftedLines();
		for (int i=0; i<numShifts; i++){
			lines.add(circularShift.getShiftedLines(i));
		}
		Collections.sort(lines);
	}
	
	// Method to return the number of output lines
	// @param
	//		null
	// @return
	//		itn: number of lines
	public int getNumLines(){
		return lines.size();
	}
	
	// Method to return the circular shift which comes with the
	// i-th ordering
	// @return
	// 		shift: String
	public String ith(int i){
		String str = lines.get(i);
		return str;
	}
	
}
