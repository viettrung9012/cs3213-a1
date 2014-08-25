import java.util.ArrayList;

// class to create, access, and possibly delete characters, words, and lines.
// @author: Boo Kuok Liang A0087547

public class LineStorage {
	
	private class Data<T> extends ArrayList<ArrayList<ArrayList<T>>> {

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
		
		
	}

	
	public void getChar(int l, int w, int c) {
		
		
	}
	
	// Method to store the word w at i-th position in j-th line
	// into the data
	// @params
	// 		w: String, i: int, j: int
	// @return
	public void setWord(int i, int j, String w){
		
	}
	
	// Method to get word at i-th index in j-th line from data
	// Return blank if out-of-range
	// @params
	//		i: int, j: int
	// @return
	//		w: String
	public String getWord(int l, int w){
		String w = "";
		return w;
	}
	
	// Method to get the number of words in j-th line
	// @params
	// 		j: int
	// @return
	//		num: int
	public int getNumWord(int l){
		int num = 0;
		return num;
	}
	
	public int getNumLines(){
		int numLine = 0;
		return numLine;
	}
	
	public int getNumChars(int l, int w) {
		
		
		
	}
	
	
	public void deleteWord() {
		
		
		
	}

	public void deleteLine() {
		
		
	}
}
