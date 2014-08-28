import java.util.ArrayList;

// class to create, access, and delete characters, words, and lines.
// @author: Boo Kuok Liang A0087547N
public class LineStorage {

	private static ArrayList<ArrayList<ArrayList<Character>>> data = new ArrayList<ArrayList<ArrayList<Character>>>();
	private static ArrayList<String> wordsToIgnore = new ArrayList<String>();
	
	// Method to store the word w at w-th position in l-th line into data
	// @params
	// 			l: int, w: int, word: String
	public void setWord(int l, int w, String word) {
		if(l<0) 
			throw new IllegalArgumentException("Line number must be positive.");
		
		else if(l > data.size()) 
			throw new ArrayIndexOutOfBoundsException("Line number exceed data size.");
		
		else if(l < data.size()-1) 			
			throw new IllegalArgumentException("Cannot add word to previous line.");
			
		else if(w<0) 			
			throw new IllegalArgumentException("Word number must be positive.");
		
		else if(!data.isEmpty() && l == data.size()-1) {
			if(w > data.get(l).size())
				throw new ArrayIndexOutOfBoundsException("Word number exceed data size.");
		}
	
			
		else if(data.isEmpty() && w > 0) // handle 0 line 0 word
					throw new ArrayIndexOutOfBoundsException("Word number exceed data size.");	

		else if(!data.isEmpty() && l == data.size()-1 && w < data.get(l).size()) 
			throw new IllegalArgumentException("Cannot add word to existing word.");
		

		ArrayList<Character> temp_char = new ArrayList<Character>();
		ArrayList<ArrayList<Character>> temp_word = new ArrayList<ArrayList<Character>>();

		for (char c : word.toCharArray()) {
			temp_char.add(c);
		}
		
		if(data.isEmpty() && l == 0) { //if data empty
			temp_word.add(temp_char);
			data.add(temp_word);
		}
		
		else if(l == data.size()-1 && w == data.get(l).size()) {	//add word to existing line				
			data.get(l).add(temp_char);
		}
		
		else if(l == data.size()) {	//add word to new line
			temp_word.add(temp_char);
			data.add(temp_word);
		}
		
		else throw new IllegalArgumentException("Some problem with line or word number.");
	}
	
	public Character getChar(int l, int w, int c) {
		String word = getWord(l,w);
		
		Character ch = word.charAt(c);
		return ch;
	}
	
	// Method to get word at i-th index in j-th line from data
	// Return blank if out-of-range
	// @params
	//		i: int, j: int
	// @return
	//		w: String
	public String getWord(int l, int w){
		//check if l and w empty/exceed 
		getNumChars(l,w);
		
		ArrayList<Character> word = data.get(l).get(w);
		
		StringBuilder builder = new StringBuilder(word.size());
		for(Character ch: word)
			builder.append(ch);

		return builder.toString();
	}
	
	// Method to get the number of words in l-th line
	// @params
	// 		j: int
	// @return
	//		num: int
	public int getNumWords(int l) {
		if(l < 0) 
			throw new IllegalArgumentException("Line number must be positive.");
		
		if(data.isEmpty())
			throw new ArrayIndexOutOfBoundsException("Data is empty.");
		
		//if(l == 0 && data.isEmpty())
			//return 0;
		
		if(l > data.size()-1)
			throw new ArrayIndexOutOfBoundsException("Line number exceed data size.");
		
		else return data.get(l).size();
	}
	
	public int getNumLines(){
		return data.size();
	}
	
	public int getNumChars(int l, int w) {
		//try{
			getNumWords(l);
		/*} catch(IllegalArgumentException e) {
			throw e;
		} catch(ArrayIndexOutOfBoundsException e) {
			throw e;
		}*/
		
		if(w < 0)
			throw new IllegalArgumentException("Word number must be positive.");
		
		if(w > data.get(l).size()-1)
			throw new ArrayIndexOutOfBoundsException("Word number exceed data size.");
		
		else return data.get(l).get(w).size();		
	}
	
	public ArrayList<String> getWordsToIgnore() {
		return wordsToIgnore;		
	}
	
	public void setWordsToIgnore(ArrayList<String> words) {
		if(words == null)
			throw new NullPointerException("List of words to ignore is null.");
		
		wordsToIgnore = words;		
	}
	
	public void deleteWord(int l, int w) {
		getNumChars(l,w);
		
		data.get(l).remove(w);
		return;
	}

	public void deleteLine(int l) {
		getNumWords(l);
		
		data.remove(l);	
		return;
	}
	
	public void display() {
		System.out.format("Total number of lines: %d \n", getNumLines());
		System.out.println();
		
		for(int i=0; i<data.size(); i++) {
			for(int j=0; j<data.get(i).size(); j++) {
					System.out.format("Line %d Word %d : ", i, j);
					System.out.println(getWord(i,j));
			}	
		}
		
		System.out.println();
		
		System.out.format("Total number of words to ignore: \n", getWordsToIgnore().size());
		for(int k=0; k<wordsToIgnore.size(); k++) 
			System.out.println(wordsToIgnore.get(k));
	}
}
