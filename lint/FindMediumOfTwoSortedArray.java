package lint;

import junit.framework.TestCase;

public class FindMediumOfTwoSortedArray extends TestCase {
	/**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
	  public double findMedianSortedArrays(int[] A, int[] B) {
	        int total = A.length+B.length;
	        if (total%2==0) {
	            return (findN(A, B, 0, A.length-1, 0, B.length-1, total/2)+ 
	                findN(A, B, 0, A.length-1, 0, B.length-1, total/2+1))/2.0;
	                
	        }
	        else {
	            return findN(A, B, 0, A.length-1, 0, B.length-1, total/2+1);
	        }
	    }
	    
	    int findN(int[]A, int[]B, int as, int ae, int bs, int be, int n){
	        if (as>ae) {
	            return B[bs+n-1];
	        }
	        else if (bs>be) {
	            return A[as+n-1];
	        }
	        else if (n==1) {
	            return Math.min(A[as], B[bs]);
	        }

	        int am = (as+ae)/2;
	        int bm = (bs+be)/2;
	        int leftSize = am-as+1 + bm-bs + 1;
	        if (A[am]>=B[bm]) {
	            if (n>=leftSize) {
	                return findN(A, B, as, ae, bm+1, be, n-(bm-bs+1));
	            }  
	            else {
	                return findN(A, B, as, am-1, bs, be, n);
	            }
	        }
	        else{
	            if (n>=leftSize) {
	                return findN(A, B, am+1, ae, bs, be, n-(am-as+1));
	            }  
	            else {
	                return findN(A, B, as, ae, bs, bm-1, n);
	            }
	        }
	        
	        
	    }
	    
	public void testFindK() {
		int[] A= new int[]{2,3,4};
    	int[] B= new int[]{1};
    	assertEquals(1, this.findN(A, B, 0,1, 0, 0, 1));
    	assertEquals(2, this.findN(A, B, 0,2, 0, 0, 2));
    	assertEquals(3, this.findN(A, B, 0,2, 0, 0, 3));
    	assertEquals(4, this.findN(A, B, 0,2, 0, 0, 4));
    	
    	A = new int[] {1,2,3,4,5,6};
    	B = new int[] {2,3,4,5};
    	assertEquals(3, this.findN(A, B, 0, 5, 0, 3, 4));
	}
    public void testSample() {
    	int[]A= new int[]{1};
    	int[]B= new int[]{2,3};
    	A= new int[]{1,2,3};
    	B= new int[]{1,2};
    	assertEquals(2.0, this.findMedianSortedArrays(A, B));
    	
    	assertEquals(2.0, this.findMedianSortedArrays(A, B));
    	A= new int[]{2,3,4};
    	B= new int[]{1};
    	assertEquals(2.5, this.findMedianSortedArrays(A, B));
    	A= new int[]{1,2};
    	B= new int[]{2,3};
    	assertEquals(2.0, this.findMedianSortedArrays(A, B));
    	A= new int[]{1,2,5};
    	B= new int[]{2,3};
    	assertEquals(2.0, this.findMedianSortedArrays(A, B));
    	
    	A = new int[] {1,2,3,4,5,6};
    	B = new int[] {2,3,4,5};
    	assertEquals(3.5, this.findMedianSortedArrays(A, B));
    }
}
