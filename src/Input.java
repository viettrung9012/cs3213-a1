import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//class to read input from file and store it in Line Storage
//@author: Boo Kuok Liang A0087547N
public class Input {
	private static LineStorage ls = new LineStorage();
	
	public static void readFile(String titles, String noises) throws IOException {
		
		FileInputStream fStream = null;		
		DataInputStream in = null;
		BufferedReader br = null;
		
		try{
			fStream = new FileInputStream(titles);
			in = new DataInputStream(fStream);
			br = new BufferedReader(new InputStreamReader(in));
			String line;
			
			int i = 0;
			String []title = null;
			List<String> temp;

			while((line = br.readLine()) != null) {
				title = line.split("\\s+");
				
				temp = new ArrayList<String>(Arrays.asList(title));
				
				for(int j=0; j<temp.size(); j++) {
					ls.setWord(i, j, temp.get(j));	
					System.out.println(temp.get(j));
				}
				i++;
			}
			
			br.close();
			
			fStream = new FileInputStream(noises);
			in = new DataInputStream(fStream);
			br = new BufferedReader(new InputStreamReader(in));
			
			line = br.readLine();
			ArrayList<String> wordsIgnore = new ArrayList<String>();
			
			while((line = br.readLine()) != null) 
				wordsIgnore.add(line);
			
			ls.setWordsToIgnore(wordsIgnore);
			ls.display();
			
			br.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {						
			br.close();
		}
	}	
	
	public static LineStorage getLineStorage(){
		return ls;
	}
}
