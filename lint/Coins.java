package lint;

import junit.framework.TestCase;

public class Coins  extends TestCase {
	public boolean firstWillWin(int[] values) {
        int n = values.length;
        if (n<=2) {
            return true;
        }
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            dp[i][i]=values[i];
        }
        for(int i=1; i<n ; i++) {
            dp[i-1][i] = Math.max(values[i], values[i-1]);
        }
        for(int j=2; j<n; j++) {
            for(int i= j-2; i>=0; i--) {
                dp[i][j] = Math.max(
                    values[i] + Math.min(dp[i+1][j-1], dp[i+2][j]),
                    values[j] + Math.min(dp[i][j-2], dp[i+1][j-1]));
            }
        }
        return dp[0][n-1]>dp[0][n-2];
    }
	
	public void testSample() {
		int[] values = new int[]{1,20,4};
		assertTrue(firstWillWin(values));
	}
}
