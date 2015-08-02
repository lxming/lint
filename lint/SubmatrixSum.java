package lint;

import java.util.HashMap;

import junit.framework.TestCase;

public class SubmatrixSum  extends TestCase {
	 /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        int m = matrix.length;
        if (m==0) {
            return new int[][]{};
        }
        int n= matrix[0].length;
        int[][] sum = new int[m][n];
        for(int i=0; i<m; i++) {
            sum[i][0]=matrix[i][0];
            for(int j=1; j<n; j++) {
                sum[i][j]=sum[i][j-1]+matrix[i][j];
            }
            int[] tmp = new int[n];
            for(int k=i; k>=0; k--) {
                for(int l=0; l<n; l++) {
                    tmp[l]=tmp[l] + sum[k][l];
                }   
                int[] found = arraySum(tmp);
                if (found!=null) {
                    return new int[][]{{k,found[0]},{i, found[1]}};
                }
            }
        }
    	return null;
    	    
    }
    
    /**
     * return the index (i,j) if the sum is zero, otherwise return null;
     */
    int[] arraySum(int[]a) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<a.length; i++) {
            if (map.get(a[i])!=null) {
                return new int[]{map.get(a[i])+1, i};
            }
            else {
                map.put(a[i], i);
            }
        }
        return null;
    }
    
    
    public void testSample() {
    	int[][] sample = new int[][]{
    		{1,5,7},
    		{3,7,-8},
    		{4,-8,9}};
    	assertTrue(this.submatrixSum(sample).length>0);
    }
}
