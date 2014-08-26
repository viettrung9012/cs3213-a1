import java.io.IOException;
import java.util.Scanner;

// Class for overall control of all activities
// @author: Boo Kuok Liang A0087547
public class MasterControl {
	public static void main(String args[]){
		System.out.println("Welcome");
		
		boolean repeat = false;
		
		do {
			
			//call input to read into line storage
			try {
				Input.readFile();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
			//call circular shift
	
			//call alphabetic shift
			
			//call output
			
			//repeat program
			System.out.print("Do you wish to continue? (Y/N)");
			Scanner sc = new Scanner(System.in);
			
			if(sc.next().compareToIgnoreCase("y") == 0)		repeat = true;
			else if(sc.next().compareToIgnoreCase("n") == 0) repeat = false;	
			//check for other input
					
			sc.close();
		} while(repeat);
	}
}
