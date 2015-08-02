package lint;

import java.util.ArrayList;

import junit.framework.TestCase;

public class MaxSubArray extends TestCase{
	public int maxSubArray(ArrayList<Integer> nums, int k) {
        int n = nums.size();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            int tmp = nums.get(i);
            dp[i][i]=tmp;
            for(int j=i+1; j<n; j++) {
                tmp = Math.max(tmp+nums.get(j), nums.get(j));
                dp[i][j] = Math.max(dp[i][j-1], tmp);
            }
        }
        
        int[][]dp2 = new int[k+1][n];
        for (int i=0; i<n; i++) {
            dp2[1][i]=dp[0][i];
        }
        for(int m=2; m<=k; m++) {
            for(int j=m-1; j<n; j++) {
                dp2[m][j] = dp2[m-1][j-1] + dp[j][j];
                for(int i=j-1; i>=m-1; i--) {
                    dp2[m][j] = Math.max(dp2[m][j], dp2[m-1][i-1] + dp[i][j]);
                }
            }
        }
        return dp2[k][n-1];
    }
	
	public void testSample() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(-1);
		al.add(4);
		al.add(-2);
		al.add(3);
		al.add(-2);
		al.add(3);
		assertEquals(8, this.maxSubArray(al, 2));
	}
}
