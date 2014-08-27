package core;
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
	
	// Method to setup circular shift as well as read in noise words
	// @params
	//		noiseWords: String[];
	// @return
	//		void
	public void addNoise(String[] noise){
		for (int i=0; i<noise.length; i++){
			noiseWords.add(noise[i]);
		}
	}
	
	// Method to add normal lines to data
	// @param
	//		null
	// @return
	//		void
	public void addData(){
		int numLines = lineStorage.getNumLines();
		for (int i=0; i<numLines; i++){
			normalLines.add(new ArrayList<String>());
			int numWords = lineStorage.getNumWord(i);
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
	public void circularShift(){
		int numLines = normalLines.size();
		for (int i=0; i<numLines; i++){
			int numWords = normalLines.get(i).size();
			for (int j=0; j<numWords; j++){
				if (!noiseWords.contains(normalLines.get(i).get(j))){
					String shifted = normalLines.get(i).get(j).toUpperCase();
					for (int k=j+1; k<numWords+j; k++){
						shifted = shifted.concat(SPACE);
						shifted = shifted.concat(normalLines.get(i).get(k%numWords).toLowerCase());
					}
					shiftedLines.add(shifted);
				}
			}
		}
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
	
	// Method to set the i-th character of j-th word in k-th circular shift as c
	// @params
	//		i: int, j: int, k: int, c: int
	// @return
	//		void
	public void setChar(int i, int j, int k, int c){
	
	}
	
	// Method to get the i-th character from j-th word in k-th circular shift
	// @params
	//		i: int, j: int, k: int
	// @return
	//		c: char
	public char getChar(int i, int j, int k){
		char c = 0;
		return c;
	}
	
	// Method to get the number of words from the k-th circular shift
	// @params
	//		k: int
	// @return
	//		num: int
	public int getNumWord(int k){
		int num = 0;
		return num;
	}
}
