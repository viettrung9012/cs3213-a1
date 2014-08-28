import java.util.ArrayList;
import java.util.HashSet;

// class to create (virtual) lines of the circular shifts 
// of the stored lines;
// provides routines to access individual characters and 
// words in the shifted lines
// @author: A0099324X
public class CircularShift {
	
	private LineStorage lineStorage;
	private ArrayList<String> shiftedLines;
	private ArrayList<ArrayList<String>> normalLines;
	private HashSet<String> noiseWords;
	
	private final String SPACE = " ";
	
	
	public CircularShift(LineStorage sto){
		lineStorage = sto;
		shiftedLines = new ArrayList<String>();
		normalLines = new ArrayList<ArrayList<String>>();
		noiseWords = new HashSet<String>();
	}
	
	// Method to run circular shift
	public void run(){
		addNoise();
		addData();
		circularShift();
	}
	
	// Method to setup circular shift as well as read in noise words
	// @params
	//		noiseWords: String[];
	// @return
	//		void
	private void addNoise(){
		ArrayList<String> noise = lineStorage.getWordsToIgnore();
		for (int i=0; i<noise.size(); i++){
			noiseWords.add(noise.get(i).toLowerCase());
		}
	}
	
	// Method to add normal lines to data
	// @param
	//		null
	// @return
	//		void
	private void addData(){
		int numLines = lineStorage.getNumLines();
		for (int i=0; i<numLines; i++){
			normalLines.add(new ArrayList<String>());
			int numWords = lineStorage.getNumWords(i);
			for (int j=0; j<numWords; j++){
				normalLines.get(i).add(lineStorage.getWord(i, j));
			}
		}
	}
	
	// Method to circular shift normal lines and save to shifted lines
	// @param
	// 		null
	// @return
	// 		void
	private void circularShift(){
		int numLines = normalLines.size();
		for (int i=0; i<numLines; i++){
			int numWords = normalLines.get(i).size();
			for (int j=0; j<numWords; j++){
				if (!noiseWords.contains(normalLines.get(i).get(j).toLowerCase())){
					String shifted = firstUpperCase(normalLines.get(i).get(j));
					for (int k=j+1; k<numWords+j; k++){
						shifted = shifted.concat(SPACE);
						shifted = shifted.concat(normalLines.get(i).get(k%numWords));
					}
					shiftedLines.add(shifted);
				}
			}
		}
	}
	
	// Method to capitalize the first character of a word
	// @param
	//		String: input
	// @return
	//		String: output
	private String firstUpperCase(String str){
		if (str.length()<=1){
			str = str.toUpperCase();
		} else {
			String str1 = str.substring(0, 1);
			String str2 = str.substring(1);
			str = str1.toUpperCase().concat(str2.toLowerCase());
		}
		return str;
	}
	
	// Method to get the number of shifted lines
	// @param
	//		null
	// @return
	//		int: number of line
	public int getNumShiftedLines(){
		return shiftedLines.size();
	}
	
	// Method to get the shifted line at line number n
	// @param
	//		int: n
	// @return
	//		String: the shifted line at n
	public String getShiftedLines(int n){
		return shiftedLines.get(n);
	}
}
