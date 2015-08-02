package lint;

import junit.framework.TestCase;

public class Obstacles extends TestCase  {
	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][]dp = new int[2][n];
        for(int i=0; i<n; i++) {
            if(obstacleGrid[0][i]==1) {
                break;
            }
            else {
                dp[0][i]=1;
            }
        }
        for(int i=1; i<m; i++) {
            if (obstacleGrid[i][0]==0 && dp[0][0]==1) {
                dp[1][0]=1;
            }
            else {
            	dp[1][0]=0;
            }
            for(int j=1; j<n; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[1][j]=0;
                }    
                else {
                    dp[1][j]=dp[0][j]+dp[1][j-1];
                }
            }
            for(int j=0; j<n; j++) {
                dp[0][j]=dp[1][j];
            }
        }
        return dp[0][n-1];
    }
    
    public void testSample() {
    	int[][]m = new int[][]{
    			{0,0},
    			{0,0},
    			{0,0},
    			{1,0},
    			{0,0}
    	};
    	assertEquals(3, this.uniquePathsWithObstacles(m));
    }
}
