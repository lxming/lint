package lint;

import junit.framework.TestCase;

public class QuickSelect  extends TestCase  {
	public int quickselect(int[]a, int k) {
		return quickselect(a, 0, a.length-1, k-1);
	}
	
	int quickselect(int[]a, int s, int e, int k) {
		int pivot = a[e];
		int j=s;
		for(int i=s; i<e; i++) {
			if (a[i]<pivot) {
				swap(a, i, j++);
			}
		}
		swap(a, j, e);
		if (j==k) {
			return a[j];
		}
		else if (j>k) {
			return quickselect(a, s, j-1, k);
		}
		else {
			return quickselect(a, j+1, e, k);
		}
		
	}
	
	public int largestk(int[]a, int k) {
		return quickselect(a, 0, a.length-1, a.length-k);
	}
	
	void swap(int[]a, int i, int j) {
		int tmp = a[i];
		a[i] =a[j];
		a[j]=tmp;
	}
	
	public void testSample() {
		int[] input= new int[]{4,3,2,1};
		assertEquals(1, quickselect(input,1));
		assertEquals(2, quickselect(input,2));
		assertEquals(3, largestk(input,2));
		assertEquals(4, largestk(input,1));
		
		input= new int[]{1,2,3,4};
		assertEquals(1, quickselect(input,1));
		assertEquals(2, quickselect(input,2));
		assertEquals(3, largestk(input,2));
		assertEquals(4, largestk(input,1));
		
	}
}
