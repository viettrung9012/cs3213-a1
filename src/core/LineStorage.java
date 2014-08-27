package core;

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
	private static ArrayList<String> wordsToIgnore = new ArrayList<String>();
	
	public Character getChar(int l, int w, int c) {
		Character ch = data.get(l).get(w).get(c);
		return ch;
	}
	
	// Method to store the word w at w-th position in l-th line into data
	// @params
	// 			l: int, w: int, word: String
	public void setWord(int l, int w, String word) {
		
		//check if l and w valid
		/******errors*******/
		if(l<0) { //error
		
		}
		
		if(l > getNumLines()) {
		}//add line, but l must be only 1 size larger than data, if not error
			
		
		if(l < getNumLines()-1) {
			
			
		}
			
		if(w<0) {
				
		}
		
		if(w > getNumWords(l)) {
			
		}
			
		if(w < getNumWords(l)-1) {
			
		}
		
		//if(c != getNumChars(l,w)) {//char must be at the exact position
			
		//}
		/******errors*******/
		ArrayList<Character> temp = new ArrayList<Character>();
		ArrayList<ArrayList<Character>> temp1 = new ArrayList<ArrayList<Character>>();

		if(l == getNumLines()) {			//add new line
			if(w == getNumWords(l)) {		//add new word
				//data.
				for (char c : word.toCharArray()) {
					temp.add(c);
				}
				
				temp1.add(temp);
				data.add(temp1);	
			}
		}
		
		else {}//error
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
	public int getNumWords(int l){
		if(data.isEmpty())
			return 0;
		
		return data.get(l).size();
	}
	
	public int getNumLines(){
		return data.size();
	}
	
	public int getNumChars(int l, int w) {
		if(data.get(l).isEmpty())
			return 0;
		
		return data.get(l).get(w).size();		
	}
	
	public ArrayList<String> getWordsToIgnore() {
		return wordsToIgnore;		
	}
	
	public void setWordsToIgnore(ArrayList<String> words) {
		wordsToIgnore = words;		
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
