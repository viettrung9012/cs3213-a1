import java.util.ArrayList;

// class to create, access, and possibly delete characters, words, and lines.
// @author: Boo Kuok Liang A0087547

public class LineStorage {
	
	/*private class Data<T> extends ArrayList<ArrayList<ArrayList<T>>> {

		private static final long serialVersionUID = 1L;
		
		public void addLine(int index, T element) {
			while (index >= this.size()) {
				this.add(new ArrayList<T>());
		    }
		    this.get(index).add(element);
		}
		
	    public void addWord(int index, int index2, T element) {
	        while (index >= this.size()) {
	            this.add(new ArrayList<T>());
	        }

	        ArrayList<T> inner = this.get(index);
	        while (index2 >= inner.size()) {
	            inner.add(null);
	        }

	        inner.set(index2, element);
	    }
	    
	    public void addChar(int index, int index2, int index3, T element) {
	        while (index >= this.size()) {
	            this.add(new ArrayList<T>());
	        }

	        ArrayList<T> inner = this.get(index);
	        while (index2 >= inner.size()) {
	            inner.add(null);
	        }

	        inner.set(index2, element);
	        
	        while (index3 >= inner.size()) {
	            inner.add(null);
	        }
	    }
		
		
	}*/
	
	private static ArrayList<ArrayList<ArrayList<Character>>> data = new ArrayList<ArrayList<ArrayList<Character>>>();
	
	public void getChar(int l, int w, int c) {
		
		
	}
	
	// Method to store the word w at w-th position in l-th line into data
	// @params
	// 			l: int, w: int, word: String
	public void setWord(int l, int w, String word){
		
		//check if l and w valid
		
		for (char c : word.toCharArray()) {
			data.get(l).get(w).add(c);
		}
	}
	
	// Method to get word at i-th index in j-th line from data
	// Return blank if out-of-range
	// @params
	//		i: int, j: int
	// @return
	//		w: String
	public String getWord(int l, int w){
		//check if l and w empty/exceed 
		ArrayList<Character> word = data.get(l).get(w);
		
		StringBuilder builder = new StringBuilder(word.size());
		for(Character ch: word)
		{
			builder.append(ch);
		}
		return builder.toString();
	}
	
	// Method to get the number of words in l-th line
	// @params
	// 		j: int
	// @return
	//		num: int
	public int getNumWord(int l){
		return data.get(l).size();
	}
	
	public int getNumLines(){
		return data.size();
	}
	
	public int getNumChars(int l, int w) {
		return data.get(l).get(w).size();		
	}
	
	public void deleteWord(int l, int w) {
		//check if word exist
		data.get(l).remove(w);
		return;
	}

	public void deleteLine(int l) {
		//check if line exist
		data.remove(l);
		return;
	}
}
