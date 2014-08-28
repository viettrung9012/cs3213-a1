import java.io.IOException;

// Class for overall control of all activities
// @author: Boo Kuok Liang A0087547N
public class MasterControl {
	public static void main(String args[]){		
		try {
			Input.readFile();
		} catch(IOException e) {
			e.getMessage();
		}
		
		//call circular shift
		CircularShift cs = new CircularShift(Input.getLineStorage());
		cs.run();
		
		//call alphabetic shift
		AlphabeticShift as = new AlphabeticShift(cs);
		as.alpha();
		
		//call output
		Output out = new Output(as);
		out.print();
	}
}
