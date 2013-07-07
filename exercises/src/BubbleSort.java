
public class BubbleSort {

	public static void sort(int[] array) {
		while(bubble(array)) {
			;
		}
	}

	private static boolean bubble(int[] array) {
		boolean sortFlag = false;
		for(int i=1; i<array.length; i++) {
			if(array[i] <  array[i-1]) {
				swap(array,i,i-1);
				sortFlag = true;
			}
		}
		return sortFlag;
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
