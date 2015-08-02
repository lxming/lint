package lint;

import junit.framework.TestCase;

public class FirstMissingPositive  extends TestCase{
	public int firstMissingPositive(int[] A) {
        for(int i=0; i<A.length; i++) {
            if (A[i]>0){
                if (A[i]<=i+1) {
                    A[A[i]-1]=A[i];
                }
                else {
                    int j=A[i];
                    while(j>i+1 && j<A.length+1 && A[j-1]!=j) {
                        int tmp = A[j-1];
                        A[j-1] = j;
                        j = tmp;
                        if (j>=1 && j<=i+1) {
                        	A[j-1] = j;
                        	break;
                        }
                    }
                }
            }
        }
        for(int i=0; i<A.length; i++) {
            if (A[i]!=i+1) {
                return i+1;
            }
        }
        return A.length+1;
    }
	
	public void testSample() {
		int[] s= new int[]{2,2,2,2,2};
		assertEquals(1, this.firstMissingPositive(s));
	}
}
