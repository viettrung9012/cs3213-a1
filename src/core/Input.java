package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	
	// Description: Read input from file and save into Line Storage module.
	// @return
	//		void
	public static void read(){
		System.out.print("Enter number of titles: ");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		String []title;
		List<String> temp;
		LineStorage ls = new LineStorage();
		
		for(int i=0; i<num; i++) {
			title = sc.next().split("\\s+");		//tokenize title by space
			temp = new ArrayList<String>(Arrays.asList(title));
			
			for(int j=0; j<temp.size(); j++) {
				ls.setWord(i, j, temp.get(j));	
				System.out.println(temp.get(j));
			}	
		}
		
		System.out.print("Enter number of words to ignore: ");
		num = sc.nextInt();
		
		ArrayList<String> wordsIgnore = new ArrayList<String>();

		while(num-- > 0) {
			wordsIgnore.add(sc.next());
		}
		
		sc.close();	
	}
	
	public static void readFile() throws IOException {
		System.out.print("Enter file name: ");
		Scanner sc = new Scanner(System.in);
		
		String fileName = sc.next();
		sc.close();
		
		// Declare and initialize local variables 
		FileInputStream fStream = null;		
		
		// Begin a block of code that handles exceptions
		try{
			// Open the file as a stream
			fStream = new FileInputStream(fileName);
			
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			
			line = br.readLine();
			int noOfTitles = Integer.parseInt(line); 
			
			int i = 0;
			String s;
			String []title = null;
			List<String> temp;
			LineStorage ls = new LineStorage();

			while (i < noOfTitles) {
				s = br.readLine();
				if(s != null)
					title = s.split("\\s+");		//tokenize title by space
				temp = new ArrayList<String>(Arrays.asList(title));
				
				for(int j=0; j<temp.size(); j++) {
					ls.setWord(i, j, temp.get(j));	
					System.out.println(temp.get(j));
				}				
			}
			
			line = br.readLine();
			int noOfWordsIgnore = Integer.parseInt(line);
			
			i = 0;
			ArrayList<String> wordsIgnore = new ArrayList<String>();
			while (i < noOfWordsIgnore) {
				wordsIgnore.add(br.readLine());
			}
			
			for(int k=0; k<wordsIgnore.size(); k++)
				System.out.println(wordsIgnore.get(k));
			
			br.close();
		}
		finally // handle any exceptions
		{			
			// If the file is open, then close it.
			if (fStream != null){								
				fStream.close();					
			}
		}		
	}
}
