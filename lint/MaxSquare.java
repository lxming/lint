package lint;

import junit.framework.TestCase;

public class MaxSquare extends TestCase {
	public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m==0) {
            return 0;
        }
        int n =  matrix[0].length;
        int max = 0;
        int[][]dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dp[i][j] = (matrix[i][j]=='1'?1:0);
            }
        }
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (dp[i][j]>0) {
                    if (i>0 && j>0 && dp[i-1][j-1]>0) {
                    	int l=1;
                    	for (;l<=dp[i-1][j-1]; l++) {
                    		if(dp[i][j-l]==0 ||dp[i-l][j]==0){
                    			break;
                    		}
                    	}
                    	dp[i][j]=l;
                    }
                    
                    max = Math.max(max, dp[i][j]*dp[i][j]);
                }
            }
        }
        return max;
    }
	
	public void testSample() {
		char[][] matrix = new char[][] { { '0', '0', '0', '1' },
				{ '1', '1', '0', '1' }, { '1', '1', '1', '1' },
				{ '0', '1', '1', '1' }, { '0', '1', '1', '1' } };
		assertEquals(9, this.maximalSquare(matrix));
	}
}
