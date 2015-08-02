package lint;

import junit.framework.TestCase;

public class Regex extends TestCase  {
	 public boolean isMatch(String s, String p) {
	        int m = s.length();
	        int n = p.length();
	        boolean[][] dp = new boolean[m+1][n+1];
	        dp[0][0]=true;
	        for(int j=1; j<=n; j++) {
	            if (j>=2 && p.charAt(j-1)=='*') {
	                dp[0][j]=dp[0][j-2];
	            }
	        }
	        for(int i=0; i<m; i++) {
	            for(int j=0; j<n; j++) {
	                if (same(s, p, i, j)) {
	                    dp[i+1][j+1]=dp[i][j];
	                }
	                else if (j>0 && '*'==p.charAt(j)) {
	                    dp[i+1][j+1]= dp[i+1][j-1] || 
	                        (same(s, p, i, j-1) &&
	                        (dp[i+1][j] ||dp[i][j+1]));
	                }
	            }
	        }
	        return dp[m][n];
	    }
	    
	    private boolean same(String s, String p, int i, int j) {
	        return i>=0 && j>=0 && s.charAt(i)==p.charAt(j) || '.'==p.charAt(j);
	    }
	 public void testSample() {
		 assertTrue(isMatch("aa", "a*"));
		 assertTrue(isMatch("a", "a*"));
	 }
}
