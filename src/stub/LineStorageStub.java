package stub;
import java.util.ArrayList;

import core.LineStorage;

//Stub for Line Storage
//@author: A0099324X

public class LineStorageStub extends LineStorage {
	private ArrayList<ArrayList<String>> storage;
	private ArrayList<String> noise;
	public LineStorageStub(){
		storage = new ArrayList<ArrayList<String>>();
		ArrayList<String> one = new ArrayList<String>();
		one.add("the");
		one.add("day");
		one.add("after");
		one.add("tomorrow");
		ArrayList<String> two = new ArrayList<String>();
		two.add("fast");
		two.add("and");
		two.add("furious");
		ArrayList<String> three = new ArrayList<String>();
		three.add("man");
		three.add("of");
		three.add("steel");
		storage.add(one);
		storage.add(two);
		storage.add(three);
		noise = new ArrayList<String>();
		noise.add("is");
		noise.add("the");
		noise.add("of");
		noise.add("and");
		noise.add("as");
		noise.add("a");
		noise.add("after");
	}
	public int getNumLines(){
		return storage.size();
	}
	public int getNumWords(int i){
		return storage.get(i).size();
	}
	public String getWord(int i, int j){
		return storage.get(i).get(j);
	}
	public ArrayList<String> getWordsToIgnore(){
		return noise;
	}
}
