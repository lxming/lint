package lint;

import junit.framework.TestCase;

public class Interleave extends TestCase  {
	 /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        int n = A.length;
       int i=0; int j=n-1;
       while(i<j) {
           while(i<j && A[i]>0) {
               i++;
           }
           while(i<j && A[j]<0) {
               j--;
           }
           swap(A, i, j);
       }
       i = 0;
       j = n/2+1;
       if (n%2==1) {
           if (A[n/2]>0) {
               i=1;
               j = n/2+1;
           }
           else {
               swap(A, 0, n/2);
               i=2;
               j = n/2+1;
           }
       }
       
       while(i<n/2 && j<n) {
           swap(A, i, j);
           i+=2;
           j+=2;
       }
   }
   
   
   void swap(int[] A, int i, int j) {
       int tmp = A[i];
       A[i] = A[j];
       A[j]=tmp;
   }
   
   public void testSample() {
	   int[] sample = new int[] {-33,-19,30,26,21,-9};
	   this.rerange(sample);
   }
}
