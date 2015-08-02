package lint;

import junit.framework.TestCase;

public class Heapify  extends TestCase {
	public void heapify(int[] A) {
        for(int i=1; i<A.length-1; i++) {
            helper(A, i);
        }
    }
    
    void helper(int[]A, int idx) {
        int parent = (idx-1)/2;
        while(idx>0 && A[parent]>A[idx]) {
            int tmp = A[idx];
            A[idx]=A[parent];
            A[parent] = tmp;
            idx = parent;
            parent = (parent-1)/2;
        }
        
    }
    
    public void testSample() {
    	int[] a = new int[] {45,39,32,11};
    	heapify(a);
    	assertEquals(11, a[0]);
    }
}
