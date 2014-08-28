import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	public void print(String output){
		PrintWriter pr;
		File out = new File(output);
		if (!out.exists()){
			try {
				out.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			pr = new PrintWriter(new BufferedWriter(new FileWriter(output)));
			int numLines = alphabeticShift.getNumLines();
			for (int i=0; i<numLines; i++){
				pr.println(alphabeticShift.ith(i));
			}
			pr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
