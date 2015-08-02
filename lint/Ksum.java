package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class Ksum   extends TestCase{
	/**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        Arrays.sort(A);
        return helper(A, k, 0, target);
    }
    
    ArrayList<ArrayList<Integer>> helper(int A[], int k, int start, int target) {
        ArrayList<ArrayList<Integer>>  result = new ArrayList<ArrayList<Integer>>();
        if (k==1) {
            for(int i=start; i<=A.length-k; i++){
                if (A[i]==target) {
                    result.add(new ArrayList<Integer>(Arrays.asList(target)));
                    return result;
                }
            }    
            return result;
        }
        for(int i=start; i<=A.length-k; i++){
            if (A[i]>target) {
                break;
            }
            ArrayList<ArrayList<Integer>>  tmp = helper(A, k-1, i+1, target-A[i]);
            for(ArrayList<Integer>l : tmp) {
                l.add(0, A[i]);
                result.add(l);
            }
        }
        return result;
    }
    
    public void testSample() {
    	int[] a = new int[]{1,4,7,10,12,15,16,18,21,23,24,25,26,29};
    	assertTrue(this.kSumII(a, 5, 113).size()>0);
    }
}
