// class for reading input from user and store data
// @author: Boo Kuok Liang A0087547

import java.util.Scanner;

public class Input {
	// Description: Read input from console and save into Line Storage module.
	// @return
	//		void
	public static void read(){
		System.out.print("Enter number of titles: ");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		while(num-- > 0) {
			//save titles to linestorage
		}
		
		System.out.print("Enter number of words to ignore: ");
		num = sc.nextInt();
		
		while(num-- > 0) {
			//save words to ignore to linestorage
			
		}
		
		sc.close();	
	}
	// Read input, call an instance of Character setChar(i, j, k, c) with
	// i the character position in the word, j the word position in the line
	// k the line number, c the character in that position converted to int
}
