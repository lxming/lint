package lint;

import junit.framework.TestCase;

public class Matrix  extends TestCase{
	 /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m==0){
            return 0;
        }
        int n = matrix[0].length;
        int x1=m-1, y1=n-1, x2=0, y2=0;
        while(x2<m-1 && matrix[x2][0]<target) {
            x2++;
        }
        while(y2<n-1 && matrix[0][y2]<target) {
            y2++;
        }
        while(x1>=1 && matrix[x1][n-1]>target) {
            x1--;
        }
        while(y1>=1 && matrix[m-1][y1]>target) {
            y1--;
        }
        int count = 0;
        for(int i=x1; i<=x2; i++) {
            for(int j=y1; j<=y2; j++) {
                if (matrix[i][j]==target) {
                    count++;
                }
            }
        }
        return count;
        
    }
    
    public void testSample() {
    	int[][] matrix = new int[][] {{1,2},{3,4}};
    	assertEquals(1, searchMatrix(matrix, 1));
    	
    	matrix = new int[][]{
    			{1, 3, 5, 7},
    		    {2, 4, 7, 8},
    		    {3, 5, 9, 10}};
    	assertEquals(2, searchMatrix(matrix, 3));
    	assertEquals(2, searchMatrix(matrix, 7));
    	assertEquals(1, searchMatrix(matrix, 10));
    	assertEquals(1, searchMatrix(matrix, 1));
    }
}
