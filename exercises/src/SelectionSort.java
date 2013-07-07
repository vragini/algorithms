
public class SelectionSort {
	
	public static void sort(int[] unsortedArray) {
		for(int i =0 ;i < unsortedArray.length; i++){
			swap(unsortedArray, findMinimum(unsortedArray, i), i);
		}
	}

	private static int findMinimum(int[] unsortedArray, int startPosition) {
		int minPosition = startPosition;
		for(int i=startPosition+1; i<unsortedArray.length; i++) {
			if(unsortedArray[i] < unsortedArray[minPosition]) {
				minPosition=i;
			}
		}
		return minPosition;
	}
	
	private static void swap(int [] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
