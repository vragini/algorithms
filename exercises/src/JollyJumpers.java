import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class JollyJumpers {

	public static String solveJollyJumpers(String inputString) {
		
		StringTokenizer tokenizer = new StringTokenizer(inputString);
		int length = tokenizer.countTokens();
		int[] sequence = new int[length];
		int i=0;
		while(tokenizer.hasMoreTokens()){
			int val = Integer.parseInt(tokenizer.nextToken());
		    if(i < length)  {
		    	sequence[i++] = val;
		    }
		}
		return solve(sequence, length);
	}

	private static String solve(int[] sequence, int length) {
		if(length == 1)
		      return "Jolly";
		      
		Set<Integer> diffs = new HashSet<Integer>();
		for(int i = 0; i < length - 1; i++){
			int diff = Math.abs(sequence[i + 1] - sequence[i]);
			if(diff <= length - 1 && diff > 0) {
				diffs.add(diff);	
			}
		}
		      
		return (diffs.size() == length - 1) ? "Jolly" : "Not Jolly";
	}
}
