import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GeneratePermutations {
	
	public static List<int[]> generatePerm(int n) {
		boolean[] used = new boolean[n];
		int[] sol = new int[n];
		List<int[]> result = new ArrayList<>();
		
		generatePerm(used, n, 0, sol, result);
		return result;
	}
	
	private static void generatePerm(boolean[] used, int n, int k,int[] sol,List<int[]> lout ) {
		if(k == n) {
			int[] copyOf = Arrays.copyOf(sol, n);
			lout.add(copyOf);
		} else {
			for(int i =0; i<n; i++) {
				if(!used[i]) {
					sol[k]=i;
					used[i]= true;
					generatePerm(used, n, k+1, sol, lout);
					used[i]=false;
				}
			}
		}
	}
}
