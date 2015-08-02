package lint;

import junit.framework.TestCase;

public class QuickSort extends TestCase {
	public void quicksort(int[] input){
		this.quicksort(input, 0, input.length-1);
		
	}
	void quicksort(int[] input, int s, int e) {
		if (s>=e) {
			return;
		}
		int pivot = input[e];
		int j=s;
		for(int i=s; i<e; i++) {
			if (input[i]<pivot) {
				swap(input, i, j++);
			}
		}
		swap(input, e, j);
		quicksort(input, s, j-1);
		quicksort(input, j+1, e);
		
	}
	
	void swap(int[] input, int a, int b) {
		int t = input[a];
		input[a] = input[b];
		input[b]=t;
	}
	
	public void testSample() {
		int[] input= new int[]{1};
		quicksort(input);
		assertEquals(1, input[0]);
		input= new int[]{1,2,3,4};
		quicksort(input);
		assertEquals(1, input[0]);
		input= new int[]{3,4,1,2};
		quicksort(input);
		assertEquals(1, input[0]);
		input= new int[]{4,3,2,1};
		quicksort(input);
		assertEquals(1, input[0]);
	}
}
