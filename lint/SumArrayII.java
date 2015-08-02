package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class SumArrayII extends TestCase {
	 /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
		int[] plain = subarraySum(A);
		int[] rotated = rotatedSum(A);
		if (plain[2]>=rotated[2]) {
		    return new ArrayList<Integer>(Arrays.asList(plain[0], plain[1]));
		}
		else {
		    return new ArrayList<Integer>(Arrays.asList(rotated[0], rotated[1]));
		}
	}
	
	int[] rotatedSum(int[] A) {
	    int[] backwardSum = new int[A.length];
	    backwardSum[A.length-1] = A[A.length-1];
	    for(int i=A.length-2; i>0; i--) {
	        backwardSum[i]=backwardSum[i+1]+A[i];
	    }
	    int[]forwardMax = new int[A.length];
	    int[]forwardIdx = new int[A.length];
	    forwardMax[0]=A[0];
	    forwardIdx[0]=0;
	    int sum=A[0];
	    for(int i=1; i<A.length-1; i++) {
	        sum=sum+A[i];
	        if (sum>forwardMax[i-1]) {
	            forwardIdx[i]=i;
	            forwardMax[i] = sum;
	        }
	        else {
	            forwardMax[i] = forwardMax[i-1];
	            forwardIdx[i] = forwardIdx[i-1];
	        }
	    }
	    
	    int maxsofar = A[0]+A[A.length-1];
	    int maxsofarStart = A.length-1;
	    int maxsofarEnd=0;
	    
	    for (int i=A.length-1; i>1; i--) {
	        int max= backwardSum[i] + forwardMax[i-1];
	        if (max>maxsofar) {
	            maxsofar = max;
	            maxsofarStart = i;
	            maxsofarEnd = forwardIdx[i-1];
	        }
	    }
	    return new int[]{maxsofarStart, maxsofarEnd, maxsofar};
	    
	}
	
	int[] subarraySum(int[] A) {
        int maxsofar = A[0];
		int maxsofarStart = 0;
		int maxsofarEnd = 0;
		int n = A.length;
        int maxendinghere = A[0];
        int maxendinghereStart = 0;
        for (int i = 1; i < n ; i++) {
            if (A[i] > maxendinghere + A[i]) {
                maxendinghereStart = i;
                maxendinghere = A[i];
            } else {
                maxendinghere = maxendinghere + A[i];
            }
            if (maxendinghere > maxsofar) {
                maxsofar = maxendinghere;
                maxsofarStart = maxendinghereStart;
                maxsofarEnd = i;
			}

		}
		return new int[]{maxsofarStart, maxsofarEnd, maxsofar};
	}
	public void testSample() {
		int[] sample = new int[] { 3, -1, 3, 4 };
		ArrayList<Integer> result = this.continuousSubarraySumII(sample);
		assertEquals(new Integer(2), result.get(0));
	}
}
