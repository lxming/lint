package lint;

import junit.framework.TestCase;

public class PostOfice  extends TestCase{
	public int postOffice(int[] A, int k) {
		int n = A.length;
		if (A.length == 0 || k == 0) {
			return 0;
		}
		int[][] cost = preCalculateCost(A);
		int[][] dp = new int[k + 1][n + 1];
		
		for (int j = 1; j <= n; j++) {
			dp[1][j] = cost[0][j-1];
		}
		
		for (int i = 2; i <= k; i++) {
			for (int j = i + 1; j <= n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int l = i; l < j; l++) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][l-1]
							+ cost[l - 1][j - 1]);
				}
			}
		}
		return dp[k][n];

	}
	    
	    int[][] preCalculateCost(int[] A) {
	        int[][] cost = new int[A.length][A.length];
	        for(int i=0; i<A.length; i++) {
	            for(int j=i+1; j<A.length; j++) {
	                int mid = (i+j)/2;
	                for(int k=i; k<mid; k++) {
	                    cost[i][j] = cost[i][j] + A[mid]-A[k];
	                }
	                for(int k=mid+1; k<=j; k++) {
	                    cost[i][j] = cost[i][j] + A[k]-A[mid];
	                }
	            }
	        }
	        return cost;
	    }
	    
	    public void testSample() {
	    	int[] A = new int[]{1,2,3,4,5};
	    	assertEquals(3, this.postOffice(A, 2));
	    }
}
