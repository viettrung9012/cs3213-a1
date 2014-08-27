package core;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// class to display output
// @author: A0099324X
public class Output {
	private AlphabeticShift alphabeticShift;
	public Output(AlphabeticShift as){
		alphabeticShift = as;
	}
	// Method to print out result
	// @param
	//		null
	// @return
	//		void
	public void print(){
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int numLines = alphabeticShift.getNumLines();
		for (int i=0; i<numLines; i++){
			pr.println(alphabeticShift.ith(i));
		}
		pr.close();
	}
}
