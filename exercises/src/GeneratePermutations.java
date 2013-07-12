import java.util.ArrayList;
import java.util.List;


public class GeneratePermutations {
	
	private static List<int[]> lout = new ArrayList<>();
	//generate_perm(used[], n , k sol[],lout)
	public static List<int[]> generatePerm(boolean[] used, int n, int k,int[] sol) {
		if(k == n) {
			lout.add(sol);
		} else {
			for(int i =0; i<n; i++) {
				if(!used[i]) {
					sol[k]=i;
					used[i]= true;
					generatePerm(used, n, k+1, sol);
					used[i]=false;
				}
			}
		}
		return lout;
	}
}
