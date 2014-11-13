
public class MergeSort {
	
	private int[] helperArray;
	private int[] numberArray;

	public int [] sort(int[] numbers) {
		numberArray = numbers;
		int unsortedArrayLength = numbers.length;
		if(unsortedArrayLength < 1) {
			return numbers;
		}
		helperArray = new int[unsortedArrayLength];
		mergesort(0, unsortedArrayLength - 1);
		
		
		return numberArray;
		
	}

	private void mergesort(int low, int high) {
		if(low < high) {
			int middle = low + (high-low)/2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		System.out.println("LOW-- "+low +" MIDDLE-- "+middle+" HIGH-- "+high);
		for (int i = low; i <= high; i++) {
		      helperArray[i] = numberArray[i];
		    }
		
		int i = low;
		int j = middle+1;
		int k = low;
		System.out.println("I-- "+i+" J-- "+j+" K-- "+k);
		while(i<=middle && j <= high) {//
			if(helperArray[i] <= helperArray[j]) {
				numberArray[k] = helperArray[i];
				i++;
			} else {
				numberArray[k] = helperArray[j];
				j++;
			}
			k++;
		}
		
		while(i<=middle) {
			numberArray[k] = helperArray[i];
			i++;
			k++;
		}
		
	}

	
}
